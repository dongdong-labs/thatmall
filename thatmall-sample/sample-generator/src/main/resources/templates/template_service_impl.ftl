package ${tableInfo.getPackageName("ServiceImpl")};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.onedayday.framework.result.Pager;
import org.onedayday.framework.result.PagerResult;

import ${tableInfo.getPackageName("DTO")}.${tableInfo.getClassName("DTO")};
import ${tableInfo.getPackageName("PO")}.${tableInfo.getClassName("PO")};
import ${tableInfo.getPackageName("DTOConverter")}.${tableInfo.getClassName("DTOConverter")};
import ${tableInfo.getPackageName("Service")}.${tableInfo.getClassName("Service")};
import ${tableInfo.getPackageName("Mapper")}.${tableInfo.getClassName("Mapper")};

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Title:  ${tableInfo.getClassName("ServiceImpl")}
 * @Description: ${tableInfo.comment}
 * @author ${tableInfo.author}
 * @date ${tableInfo.createDate}
 * @version 1.0
 */

@Service("${tableInfo.getClassName("ServiceImpl")?replace('Impl', '' )?uncap_first}")
@RequiredArgsConstructor
@Slf4j
public class ${tableInfo.getClassName("ServiceImpl")}  implements ${tableInfo.getClassName("Service")} {

    private final ${tableInfo.getClassName("Mapper")} ${tableInfo.getClassName("Mapper")?uncap_first};

    private final ${tableInfo.getClassName("DTOConverter")} ${tableInfo.getClassName("DTOConverter")?uncap_first};

    /**
     * 保存${tableInfo.getClassName("PO")}
     *
     * @param ${tableInfo.getClassName("DTO")?uncap_first}
     * @return
     */
    @Override
    public int save${tableInfo.getClassName("PO")}(${tableInfo.getClassName("DTO")} ${tableInfo.getClassName("DTO")?uncap_first}) {
        return  ${tableInfo.getClassName("Mapper")?uncap_first}.insert(${tableInfo.getClassName("DTOConverter")?uncap_first}.toSource(${tableInfo.getClassName("DTO")?uncap_first}));
    }

    /**
     * 批量删除${tableInfo.getClassName("PO")}
     *
     * @param ids
     * @return
     */
    @Override
    public int delete${tableInfo.getClassName("PO")}(Set<Long> ids) {
        return ${tableInfo.getClassName("Mapper")?uncap_first}.deleteBatchIds(ids);
    }

    /**
     * 更新${tableInfo.getClassName("PO")}
     *
     * @param ${tableInfo.getClassName("DTO")?uncap_first}
     * @return
     */
    @Override
    public int update${tableInfo.getClassName("PO")}(${tableInfo.getClassName("DTO")} ${tableInfo.getClassName("DTO")?uncap_first}) {
        return ${tableInfo.getClassName("Mapper")?uncap_first}.updateById(${tableInfo.getClassName("DTOConverter")?uncap_first}.toSource(${tableInfo.getClassName("DTO")?uncap_first}));
    }

    /**
     * ${tableInfo.getClassName("PO")}分页
     *
     * @param pager<${tableInfo.getClassName("DTO")?uncap_first}>
     * @return
     */
    @Override
    public  PagerResult<${tableInfo.getClassName("DTO")}> getPageResult(Pager<${tableInfo.getClassName("DTO")}> pager) {
        QueryWrapper<${tableInfo.getClassName("PO")} > queryWrapper = new QueryWrapper<>();
        Page<${tableInfo.getClassName("PO")}> page = new Page<>();
        page.setCurrent(pager.getPage());
        page.setSize(pager.getSize());
        IPage<${tableInfo.getClassName("PO")}> iPage = ${tableInfo.getClassName("Mapper")?uncap_first}.selectPage(page,queryWrapper);
        PagerResult<${tableInfo.getClassName("DTO")}> result = new PagerResult<>();
        result.setList(${tableInfo.getClassName("DTOConverter")?uncap_first}.toTargetList(iPage.getRecords()));
        result.setTotal((int) iPage.getTotal());

        return result;
    }
}
