package org.onedayday.framework.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author onedayday
 */
@Data
public class Pager<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 每页显示
     */
    private int size = 10;

    /**
     * 页码
     */
    private int page = 1;

    /**
     * 下标
     */
    private int offset = 0;

    /**
     * 对象泛型
     */
    private T condition;


    public void setPage(int pageNo) {
        if (pageNo > 0) {
            this.page = pageNo;
            recalcOffset();
        }
    }

    /**
     * 重新计算下标
     */
    private void recalcOffset() {
        if (page > 0 && offset == 0) {
            offset = (page - 1) * size;
        }
    }

    public void setSize(int size) {
        if (size > 0) {
            this.size = size;
            recalcOffset();
        }
    }

}