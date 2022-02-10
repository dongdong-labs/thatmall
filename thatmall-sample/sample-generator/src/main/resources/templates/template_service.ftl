package ${tableInfo.getPackageName("Service")};

import ${tableInfo.getPackageName("DTO")}.${tableInfo.getClassName("DTO")} ;
import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;
import java.util.Set;
/**
 * @Title: ${tableInfo.getClassName("Service")}
 * @Description:
 * @author ${tableInfo.author}
 * @date ${tableInfo.createDate}
 * @version 1.0
 */

public interface ${tableInfo.getClassName("Service")}{

    /**
     * 保存${tableInfo.getClassName("PO")}
     *
     * @param ${tableInfo.getClassName("DTO")?uncap_first}
     * @return
     */
    int save${tableInfo.getClassName("PO")}(${tableInfo.getClassName("DTO")} ${tableInfo.getClassName("DTO")?uncap_first});

    /**
     * 批量删除${tableInfo.getClassName("PO")}
     *
     * @param ids
     * @return
     */
    int delete${tableInfo.getClassName("PO")}(Set<Long> ids);

    /**
     * 更新${tableInfo.getClassName("PO")}
     *
     * @param ${tableInfo.getClassName("DTO")?uncap_first}
     * @return
     */
    int update${tableInfo.getClassName("PO")}(${tableInfo.getClassName("DTO")} ${tableInfo.getClassName("DTO")?uncap_first});

    /**
     * ${tableInfo.getClassName("PO")}分页
     *
     * @param pager<${tableInfo.getClassName("DTO")?uncap_first}>
     * @return
     */
    PagerResult<${tableInfo.getClassName("DTO")}> getPageResult(Pager<${tableInfo.getClassName("DTO")}> pager);

}
