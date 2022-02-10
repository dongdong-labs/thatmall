
    <#if tableList??>
        <#list tableList as tableInfo>
    <dubbo:reference check="false" interface="${tableInfo.getPackageName("Service")}.${tableInfo.getClassName("Service")}" id="${tableInfo.getClassName("ServiceImpl")?replace('Impl', '' )?uncap_first}"/>
        </#list>
    </#if>




