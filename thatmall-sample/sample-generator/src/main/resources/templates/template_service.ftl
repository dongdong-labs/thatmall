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

    int save${tableInfo.getClassName("PO")}(${tableInfo.getClassName("DTO")} ${tableInfo.getClassName("DTO")?uncap_first});

    int delete${tableInfo.getClassName("PO")}(Set<Long> ids);

    int update${tableInfo.getClassName("PO")}(${tableInfo.getClassName("DTO")} ${tableInfo.getClassName("DTO")?uncap_first});

    PagerResult<${tableInfo.getClassName("DTO")}> getPageResult(Pager<${tableInfo.getClassName("DTO")}> pager);

}
