//package com.onedayday.gateway.filter;
//
//import com.alibaba.fastjson.JSON;
//
//import com.onedayday.gateway.util.RequestDataExtractor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.StringUtils;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.nio.charset.StandardCharsets;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.function.Consumer;
//
//
///**
// * @program: report
// * @class: AuthFilter
// * @description:
// * @author: wdd
// * @create: 2020-10-01 13:53
// */
//@Slf4j
//@Component
//public class AuthFilter implements GlobalFilter, Ordered {
//    @Autowired
//    private RedisUtil redisUtil;
//
//    private String[] skipAuthUrls;
//
//    @Value("${macList:a4-bb-6d-aa-40-5f}")
//    private String[] macList;
//
//    @Value("${system.customerName:system}")
//    private String systemCustomerName;
//
//    @Value("${system.customerTypeCode:system}")
//    private String systemCustomerTypeCode;
//
//    @Value("${system.registrationCode:system}")
//    private String systemRegistrationCode;
//
//    private static Boolean  flag = true;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        log.info("================进入filter请求==========");
//        ServerHttpRequest request = exchange.getRequest();
//        ServerHttpResponse response = exchange.getResponse();
//        String path = RequestDataExtractor.getPath(request);
////        if(true){ return chain.filter(exchange);}//测试时打开，放行所有请求
//        //校验是否是可以直接访问的路径，例如登录接口
//        if (isPass(path)) {
//            return chain.filter(exchange);
//        }
//        //是否需要进行地址校验
////        if (flag){
////            String mac = MacUtils.getMAC();
////            log.info("macs == {}", Arrays.toString(macList));
////            log.info("mac == =========== {}",mac);
////            if (macList == null || !ArrayUtils.contains(macList,mac)) {
////                return this.returnData(40000, "当前地址异常,请联系管理员!", exchange);
////            }
////            flag = false;
////        }
//
////        //从请求头中获取token
////        String token = RequestDataExtractor.getHeader(request, "token");
////        JwtUtil jwtUtil = new JwtUtil();
////        jwtUtil.validateToken(token,"");
////        //校验token
////        DecodedJWT decodedJWT = null;
////        try {
////            decodedJWT = Sign.verifySessionToken(token, "secret");
////        } catch (TokenExpiredException e) {
////            return this.returnData(ResultCode.UN_AUTHORIZED.getCode(), "登录状态已失效，请重新登录", exchange);
////        } catch (Exception e) {
////            log.info(e.getMessage(), e);
////            return this.returnData(ResultCode.UN_AUTHORIZED.getCode(), "您还未登录哟", exchange);
////        }
//
////        boolean checkToken = JwtUtils.checkTokenWithTokenHeader(request, "Hrsyabc");//联调成功的token
//        boolean checkToken = JwtUtils.checkTokenWithTokenHeader(request, "hrsyabc");//联调成功的token
//        if (!checkToken) {
//            return this.returnData(Integer.valueOf(ErrorCodeEnums.NO_LOGIN.getCode()), ErrorCodeEnums.NO_LOGIN.getMsg(), exchange);
//        }
//        Map<String, String> mapByJwtToken = JwtUtils.getMapByJwtTokenWithTokenHeader(request, "hrsyabc");//联调成功
//        if (CollectionUtils.isEmpty(mapByJwtToken)) {
//            return this.returnData(Integer.valueOf(ErrorCodeEnums.NO_LOGIN.getCode()), ErrorCodeEnums.NO_LOGIN.getMsg(), exchange);
//        }
//        //从redis中获取token, 如果能拿到 刷新时间 ，拿不到过期
//        String userId = mapByJwtToken.get("userId");
//        //String key = String.format(RedisKeyConstant.REDIS_KEY_TOKEN, userId, mapByJwtToken.get("token"));
//
//        //todo 先注掉
//      /*  if (redisUtil.hasKey(key)){
//            //有，刷新
//            redisUtil.expire(key,redisUtil.getExpire(key));
//        }else {
//            //设置跳转登录页面
//            try {
//                //让浏览器知道要重定向
//                response.setStatusCode(HttpStatus.SEE_OTHER); //303
//                //重定向到登录页面  响应头
//                response.getHeaders().add(
//                        HttpHeaders.LOCATION,"www.baidu.com" +
//                                URLEncoder.encode(request.getURI().getRawSchemeSpecificPart(),"utf-8"));
//                //todo 这个跳转不出去
//                //return response.setComplete();
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//        }*/
//        String deptId = mapByJwtToken.get("deptId");
//        if (StringUtils.isEmpty(deptId)) {
//            //null无法塞入请求头
//            deptId = "";
//        }
//        log.info("当前登录用户=={}    的deptID=== {}",userId,deptId);
//        String finalDeptId = deptId;
//        Consumer<HttpHeaders> httpHeaders = httpHeader -> {
//            httpHeader.set("userId", userId);
//            httpHeader.set("deptId", finalDeptId);
//            httpHeader.set("systemCustomerName",systemCustomerName);
//            httpHeader.set("systemCustomerTypeCode",systemCustomerTypeCode);
//            httpHeader.set("systemRegistrationCode",systemRegistrationCode);
//        };
//        RequestDataExtractor.addHeader(exchange, httpHeaders);
//        return chain.filter(exchange);
//    }
//
//    /**
//     * 校验不需要token可以直接访问的路径
//     */
//    private boolean isPass(String path) {
//        HashSet<String> paths = new HashSet<>();
//
//        paths.add("/gateway/Mac/listMac");
//        //数据工程导入报表文件
//        paths.add("/datacenter/import/dataImportAssets");
//        paths.add("/datacenter/import/dataImportProfit");
//        paths.add("/datacenter/import/dataImportCashflow");
//        paths.add("/datacenter/import/dataImportAssetsByFile");
//        paths.add("/datacenter/import/dataImportProfitByFile");
//        paths.add("/datacenter/import/dataImportCashflowByFile");
//        paths.add("/datacenter/datainfo/getMacAddress");
//        paths.add("/datacenter/datainfo/getCustomerCount");
//
//        paths.add("/usercenter/auth/token");
//        paths.add("/usercenter/login");
//        paths.add("/usercenter/wx/wxLogin");
//        paths.add("/usercenter/loginByPhone");
//        paths.add("/usercenter/getParentDeptName");
//        // paths.add("/usercenter/test");
//        paths.add("/usercenter/register");
//        paths.add("/usercenter/forgetPassword");
//        paths.add("/usercenter/registerNew");
//        paths.add("/usercenter/checkout");
//        //验证手机号
//        paths.add("/usercenter/checkoutPhone");
//        paths.add("/usercenter/resetPassword");
//        paths.add("/usercenter/updatePassword");
//        //发短信
//        paths.add("/usercenter/getAuthCode");
//        //单点登录
//        paths.add("/usercenter/singleLogin/singleLoginOrRegister");
//        paths.add("/usercenter/singleLogin/savePhoneCache");
//        paths.add("/usercenter/singleLogin/saveOrLogin");
//        //跑行业值数据
//        paths.add("/basecenter/csrcIndustryParam/updateValue");
//        paths.add("/tradecenter/v2/api-docs");
//        paths.add("/usercenter/v2/api-docs");
//        paths.add("/customercenter/v2/api-docs");
//        paths.add("/abutmentcenter/v2/api-docs");
//        paths.add("/datacenter/v2/api-docs");
//        paths.add("/reportcenter/v2/api-docs");
//        paths.add("/reportcentral/v2/api-docs");
//        paths.add("/basecenter/v2/api-docs");
//        paths.add("/osscenter/v2/api-docs");
//        paths.add("/templatecenter/v2/api-docs");
//        paths.add("/definecenter/v2/api-docs");
//        paths.add("/definecenter/createReport/getTemplateInstantiationList");
//        paths.add("/definecenter/createReport/updateRelation");
//
//        return paths.contains(path) ? true : false;
//    }
//
//    /**
//     * 返回值的封装
//     */
//    private Mono<Void> returnData(Integer code, String msg, ServerWebExchange exchange) {
//        ServerHttpResponse response = exchange.getResponse();
//        byte[] datas = JSON.toJSONString(JsonResult.success(String.valueOf(code), msg)).getBytes(StandardCharsets.UTF_8);
//        DataBuffer buffer = response.bufferFactory().wrap(datas);
//        response.setStatusCode(HttpStatus.OK);
//        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
//        return response.writeWith(Mono.just(buffer));
//    }
//
//    @Override
//    public int getOrder() {
//        return -10;
//    }
//}
