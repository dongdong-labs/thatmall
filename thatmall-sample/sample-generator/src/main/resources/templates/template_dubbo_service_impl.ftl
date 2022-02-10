package ${tableInfo.getPackageName("ExportServiceImpl")};

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ${tableInfo.getPackageName("ExportService")}.${tableInfo.getClassName("ExportService")};
import java.util.Set;

/**
 * @Title:  ${tableInfo.getClassName("ExportServiceImpl")}
 * @Description: ${tableInfo.comment}
 * @author ${tableInfo.author}
 * @date ${tableInfo.createDate}
 * @version 1.0
 */

@Service("${tableInfo.getClassName("ExportServiceImpl")?replace('Impl', '' )?uncap_first}")
@RequiredArgsConstructor
@Slf4j
public class ${tableInfo.getClassName("ExportServiceImpl")}  implements ${tableInfo.getClassName("ExportService")} {

}
