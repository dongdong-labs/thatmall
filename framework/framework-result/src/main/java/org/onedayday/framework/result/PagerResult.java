package org.onedayday.framework.result;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author onedayday
 */
@Data
public class PagerResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<T> list = Collections.emptyList();

    private long total;

}
