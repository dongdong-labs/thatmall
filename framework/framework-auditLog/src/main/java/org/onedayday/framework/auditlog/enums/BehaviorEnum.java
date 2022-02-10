package org.onedayday.framework.auditlog.enums;

/**
 * @program: framework
 * @class: BehaviorEnum
 * @description:
 * @author: wdd
 * @create: 2022-02-08 17:15
 */
public enum BehaviorEnum {
    SAVE(1, "新建"),
    UPDATE(2, "编辑"),
    DELETE(3, "删除"),
    EXCEL_IMPORT(6, "导入"),
    EXCEL_EXPORT(7, "导出"),
    LOCK(11, "锁定"),
    UNLOCK(12, "解锁"),
    UPLOAD(18, "上传"),
    PUT_ON_SALE(22, "上架"),
    PUT_OFF_SALE(23, "下架"),
    START(24, "启用"),
    STOP(25, "停用"),
    FORBID(35, "禁用"),
    RESET(36, "重置"),
    COPY(37, "复制"),
    NULL(0, "null");

    private int type;
    private String name;

    BehaviorEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static BehaviorEnum valueOf(int type) {
        for (BehaviorEnum behaviorEnum : BehaviorEnum.values()) {
            if (behaviorEnum.getType() == type) {
                return behaviorEnum;
            }
        }
        return NULL;
    }
}
