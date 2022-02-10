package org.onedayday.generator.service;


public interface GeneratorService {
    /**
     *
     * @param dbName  生成结构的数据库名称
     * @param moduleName  生成结构的 模块名称 表现为  [moduleName].***
     * @param tableNames  要生成结构的表名会替换 开头 t_
     */
    void generator(String dbName,String moduleName,String[] tableNames);
    void generator(String dbName,String moduleName,String[] tableNames,String author);
}
