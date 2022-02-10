package org.onedayday.framework.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: framework
 * @class: BaseEntity
 * @description:
 * @author: wdd
 * @create: 2022-02-04 16:35
 */
@Data
public class BaseEntity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 删除标记（1删除 0 未删除）
     */
    @TableLogic
    private Integer deleted;

    /**
     * 版本标记
     */
    private Integer version;

    /**
     * 更新时间
     */
    private Date modifyTime;

    /**
     * 创建时间
     */
    private Date createTime;
}
