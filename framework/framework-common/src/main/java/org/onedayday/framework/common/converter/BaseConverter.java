package org.onedayday.framework.common.converter;

import java.util.List;

/**
 * @program: BaseConverter
 * @class: BaseConverter
 * @description:
 * @author: wdd
 */
public interface BaseConverter<Source, Target> {

    Target toTarget(Source source);

    Source toSource(Target target);

    List<Target> toTargetList(List<Source> sourceList);

    List<Source> toSourceList(List<Target> targetList);
}
