package org.onedayday.generator.service;

import org.onedayday.generator.entity.ColumnInfo;
import org.onedayday.generator.entity.TableInfo;
import org.onedayday.generator.utils.ColUtil;
import org.onedayday.generator.utils.FileNameUtil;
import org.onedayday.generator.utils.FreeMarkerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GeneratorServiceImpl implements GeneratorService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<Map<String, Object>> getTableNames(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public void generator(String dbName, String moduleName, String[] tableNames) {
       this.generator(dbName, moduleName, tableNames,"generator");
    }

    @Override
    public void generator(String dbName, String moduleName, String[] tableNames, String author) {
        String tableSql = "select TABLE_NAME,TABLE_COMMENT from information_schema.tables where table_schema='%s'";
        if (tableNames != null && tableNames.length > 0) {
            tableSql += " and TABLE_NAME in (" + Arrays.asList(tableNames).stream().map(s -> "\'" + s + "\'").collect(Collectors.joining(", ")) + ")";
        }
        List<Map<String, Object>> list = getTableNames(String.format(tableSql, dbName));
        String columnSql = "select TABLE_NAME,COLUMN_NAME,DATA_TYPE,COLUMN_TYPE,COLUMN_COMMENT,COLUMN_KEY from information_schema.columns where table_schema='%s' and table_name='%s'";
        Map map3 = new HashMap<>();
        map3.put("hasTimestamp", false);
        map3.put("hasBigDecimal", false);
        List<TableInfo> dubboList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            TableInfo tableInfoVO = new TableInfo();
            tableInfoVO.setAuthor(author);
            String name = map.get("TABLE_NAME").toString();
            tableInfoVO.setTableName(name);
            tableInfoVO.setComment(map.get("TABLE_COMMENT").toString());
            name = name.replaceFirst("t_", "");
            tableInfoVO.setClassName(FileNameUtil.firstCharacterToUpper(FileNameUtil.replaceUnderlineAndfirstToUpper(name, "_", "")));
            tableInfoVO.setModuleName(moduleName);
            List<Map<String, Object>> columnList = getTableNames(String.format(columnSql, dbName, tableInfoVO.getTableName()));
            List<ColumnInfo> columns = new ArrayList<>();
            for (int j = 0; j < columnList.size(); j++) {
                Map<String, Object> columnMap = columnList.get(j);

                if (columnMap.get("COLUMN_NAME").toString().equals("create_time")) {
                    continue;
                }
                if (columnMap.get("COLUMN_NAME").toString().equals("version")) {
                    continue;
                }
                if (columnMap.get("COLUMN_NAME").toString().equals("modify_time")) {
                    continue;
                }
                if (columnMap.get("COLUMN_NAME").toString().equals("deleted")) {
                    continue;
                }
//                if(map1.get("COLUMN_NAME").toString().equals("create_by")){
//                    continue;
//                }
//                if(map1.get("COLUMN_NAME").toString().equals("update_by")){
//                    continue;
//                }
                if (columnMap.get("COLUMN_NAME").toString().equals("id")) {
                    continue;
                }
                ColumnInfo fieldInfoVO = new ColumnInfo();
                fieldInfoVO.setPkFlag(columnMap.get("COLUMN_KEY").toString().equals("PRI"));
                fieldInfoVO.setFieldName(columnMap.get("COLUMN_NAME").toString());
                fieldInfoVO.setAttrName(FileNameUtil.replaceUnderlineAndfirstToUpper(columnMap.get("COLUMN_NAME").toString(), "_", ""));
                fieldInfoVO.setFieldType(columnMap.get("DATA_TYPE").toString());
                String colType = ColUtil.cloToJava(columnMap.get("DATA_TYPE").toString());
                // 是否存在 Timestamp 类型的字段
                if ("Timestamp".equals(colType)) {
                    map3.put("hasTimestamp", true);
                }
                // 是否存在 BigDecimal 类型的字段
                if ("BigDecimal".equals(colType)) {
                    map3.put("hasBigDecimal", true);
                }

                fieldInfoVO.setFieldComment(columnMap.get("COLUMN_COMMENT").toString());
                fieldInfoVO.setDisplayName(columnMap.get("COLUMN_COMMENT").toString());
                columns.add(fieldInfoVO);
            }

            map3.put("tableInfo", tableInfoVO);
            map3.put("columnInfoList", columns);
            for (Map.Entry<String, String> entry : getAdminTemplateNames(tableInfoVO).entrySet()) {
                FreeMarkerUtils.generate(map3, entry.getValue(), "src/test/java/gen/" + entry.getKey());
                log.info("====={}===={}====", entry.getKey(), entry.getValue());
            }
            dubboList.add(tableInfoVO);
        }
        Map map = new HashMap();
        map.put("tableList", dubboList);
        FreeMarkerUtils.generate(map, "template_dubbo_consumer.ftl", "src/test/java/gen/dubbo/dubbo-consumer.xml");
        FreeMarkerUtils.generate(map, "template_dubbo_provider.ftl", "src/test/java/gen/dubbo/dubbo-provider.xml");
    }

    private Map<String, String> getAdminTemplateNames(TableInfo tableInfo) {
        Map<String, String> templateNames = new LinkedHashMap();
        templateNames.put("controller/" + tableInfo.getFileName("Controller"), "template_controller.ftl");
        templateNames.put("controller/" + tableInfo.getFileName("Request"), "template_request.ftl");
        templateNames.put("controller/" + tableInfo.getFileName("Response"), "template_response.ftl");
        templateNames.put("controller/" + tableInfo.getFileName("ResponseConverter"), "template_converter_response.ftl");
        templateNames.put("controller/" + tableInfo.getFileName("RequestConverter"), "template_converter_request.ftl");
        templateNames.put("impl/" + tableInfo.getFileName("DTOConverter"), "template_converter_dto.ftl");
        templateNames.put("impl/" + tableInfo.getFileName("ServiceImpl"), "template_service_impl.ftl");
        templateNames.put("dao/" + tableInfo.getFileName("Mapper"), "template_mapper.ftl");
        templateNames.put("service/" + tableInfo.getFileName("DTO"), "template_dto.ftl");
        templateNames.put("dao/" + tableInfo.getFileName("PO"), "template_entity.ftl");
        templateNames.put("service/" + tableInfo.getFileName("Service"), "template_service.ftl");
        templateNames.put("export/" + tableInfo.getFileName("ExportService"), "template_dubbo_service.ftl");
        templateNames.put("export/" + tableInfo.getFileName("ExportServiceImpl"), "template_dubbo_service_impl.ftl");
        return templateNames;
    }

}
