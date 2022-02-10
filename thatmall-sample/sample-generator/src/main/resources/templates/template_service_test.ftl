package ${tableInfo.serviceTestPackageName};


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import ${tableInfo.poPackageName}.${tableInfo.poClassName};
import ${tableInfo.servicePackageName}. ${tableInfo.serviceClassName};
<#if columnInfoList??>
    <#list columnInfoList as column>
        <#if column.dataTypeEnum.importFlag==true>
import ${column.dataTypeEnum.fullType} ;
        </#if>
    </#list>
</#if>

/**   
 * @Title: ${tableInfo.serviceClassName}Test
 * @Description:
 * @author wdd
 * @date ${tableInfo.createDate}
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback
public class ${tableInfo.serviceClassName}Test {

  @Autowired
  private ${tableInfo.serviceClassName} service;

  private ${tableInfo.poClassName} get${tableInfo.poClassName}(Long id){
     ${tableInfo.poClassName} entity = new ${tableInfo.poClassName}() ;


    <#if columnInfoList??>
        <#list columnInfoList as column>
            <#if column.pkFlag==true >
    entity.set${column.attrName?cap_first}(id);
            </#if>
           <#if column.dataTypeEnum.javaType=="String" >
    entity.set${column.attrName?cap_first}("111");
           </#if>
            <#if column.dataTypeEnum.javaType=="Long" && column.pkFlag==false>
    entity.set${column.attrName?cap_first}(1L);
            </#if>
            <#if column.dataTypeEnum.javaType=="Integer" >
    entity.set${column.attrName?cap_first}(1);
            </#if>
            <#if column.dataTypeEnum.javaType=="Double" >
    entity.set${column.attrName?cap_first}(1D);
            </#if>
            <#if column.dataTypeEnum.javaType=="BigDecimal" >
    entity.set${column.attrName?cap_first}(BigDecimal.TEN);
            </#if>
            <#if column.dataTypeEnum.javaType=="Date" >
    entity.set${column.attrName?cap_first}(new Date());
            </#if>
            <#if column.dataTypeEnum.javaType=="Timestamp" >
    entity.set${column.attrName?cap_first}( new Timestamp(System.currentTimeMillis()));
            </#if>
        </#list>
    </#if>

     return  entity;
  }

  private List<${tableInfo.poClassName}> get${tableInfo.poClassName}List(){

    List<${tableInfo.poClassName}> list = new ArrayList<>();
    for (int i = 1; i < 15 ; i++) {
        list.add(get${tableInfo.poClassName}(i+0L));
    }
    return list;
  }

    /**
    * 保存  生成id属性
    *
    * @param
    * @return
    */
    @Test
    public void  save(){
        ${tableInfo.poClassName} entity =  service.save(get${tableInfo.poClassName}(1L));
        assert entity != null;
    }



    /**
    * 保存列表 自动生成id属性
    *
    * @param
    * @return
    */
    @Test
    public void saveList(){
        int count=   service.saveList(get${tableInfo.poClassName}List());
        assert count>0;
    }


    /**
    * 更新所有字段
    *
    * @param
    * @return
    */
    @Test
    public void update(){
        int count =  service.update(get${tableInfo.poClassName}(1L));
        assert count>0;
    }
    /**
    * 更新对象的非空属性字段
    *
    * @param
    * @return
    */
    @Test
    public void updateSelective(){
        int count =  service.updateSelective(get${tableInfo.poClassName}(1L));
        assert count>0;
    }


    /**
    * 根据key查询对象
    * @param
    * @return
    */
    @Test
    public void get(){
        ${tableInfo.poClassName} entity = service.get(1l);
        assert entity != null;
    }
    /**
    * 查询列表
    * @param
    * @return
    */
    @Test
    public void select(){
        List<${tableInfo.poClassName}> entity = service.select(get${tableInfo.poClassName}(1L));
        assert entity != null&& entity.size()>0;
    }

    /**
    * 查询实体
    * @param
    * @return
    */
    @Test
    public void selectOne(){
    ${tableInfo.poClassName} entity = service.selectOne(get${tableInfo.poClassName}(1L));
    assert entity != null;
    }
<#--    /**-->
<#--    * 分页查询-->
<#--    * @param-->
<#--    * @return-->
<#--    */-->
<#--    @Test-->
<#--    public void getPagerResult(){-->
<#--        Pager pager = new Pager();-->
<#--        pager.setCondition(get${tableInfo.poClassName}(1L));-->
<#--        PagerResult pagerResult =  service.getPagerResult(pager);-->
<#--        assert  pagerResult.getTotal()>0;-->
<#--    }-->

    /**
    * 删除
    * @param
    * @return
    */
    @Test
    public void delete(){
        int count =  service.delete(get${tableInfo.poClassName}(1L));
        assert count>0;
    }
    /**
    * 批量删除
    * @param
    * @return
    */
    @Test
    public void deleteByIds(){
        int count =  service.deleteByIds(new Long[]{1L});
        assert count>0;
    }
}