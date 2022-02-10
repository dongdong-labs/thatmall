

    <#if tableList??>
        <#list tableList as tableInfo>
    <dubbo:service  interface="${tableInfo.getPackageName("Service")}.${tableInfo.getClassName("Service")}" ref="${tableInfo.getClassName("ServiceImpl")?replace('Impl', '' )?uncap_first}"/>
        </#list>
    </#if>






