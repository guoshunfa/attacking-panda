package com.panda.framework.generate;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import com.panda.common.base.*;

import java.util.Collections;

/**
 * mybatis plus 代码生成<br/>
 * 详细配置请前往 https://baomidou.com/pages/981406/
 *
 * @author GuoShunFa
 */
public class CodeGenerate {

    // 数据库url地址
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/attacking-panda-db?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    // 数据库用户名
    public static final String USERNAME = "root";
    // 数据库密码
    public static final String PASSWORD = "guoshunfa";
    // 代码开发作者
    public static final String AUTHOR = "guoshunfa";
    // 代码生成到指定目录
    public static final String OUTPUT_DIR = "/Users/guoshunfa/workspace/my/my-main-git-project/attacking-panda/attacking-panda-java/codeGenerate";
    // 父包名
    public static final String PARENT = "com.panda";
    // 父包模块
    public static final String MODULE_NAME = "system";
    // 需要生成的表
    public static final String[] ADD_INCLUDE = {"sys_menu"};
    // 设置过滤表前缀，例子："t_", "c_"
    public static final String[] ADD_TABLE_PREFIX = {};

    public static void main(String[] args) {
        FastAutoGenerator.create(
                        new DataSourceConfig.Builder(URL, USERNAME, PASSWORD)
                                .dbQuery(new MySqlQuery()) // 数据库查询
                                .schema("") // 数据库 schema(部分数据库适用)
//                        .typeConvert(new MySqlTypeConvert()) // 数据库类型转换器
                                .keyWordsHandler(new MySqlKeyWordsHandler()) // 数据库关键字处理器
                ) // 数据库配置
                // ----------------------------------全局配置----------------------------------
                .globalConfig(builder -> {
                    builder.fileOverride() // 覆盖已生成文件，默认值:false
//                            .disableOpenDir() // 禁止打开输出目录，默认值:true
                            .outputDir(OUTPUT_DIR) // 指定输出目录
                            .author(AUTHOR) // 作者名
//                            .enableKotlin() // 开启 kotlin 模式，默认值:false
                            .enableSwagger() // 开启 swagger 模式，默认值:false
                            .dateType(DateType.TIME_PACK) // 时间策略
                            .commentDate("yyyy-MM-dd"); // 注释日期
                })
                // ----------------------------------包配置----------------------------------
                .packageConfig(builder -> {
                    builder.parent(PARENT) // 父包名 默认值:com.baomidou
                            .moduleName(MODULE_NAME) // 父包模块名 默认值:无
                            .entity("entity") // Entity 包名	默认值:entity
                            .service("service") // 	Service 包名	默认值:service
                            .serviceImpl("service.impl") // Service Impl 包名	默认值:service.impl
                            .mapper("mapper") // Mapper 包名	默认值:mapper
                            .xml("mapper.xml") // Mapper XML 包名	默认值:mapper.xml
                            .controller("controller") // Controller 包名	默认值:controller
                            .other("other") // 自定义文件包名	输出自定义文件时所用到的包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, OUTPUT_DIR)) // 路径配置信息
                            .build();
                })
                // ----------------------------------模板配置----------------------------------
//                .templateConfig(builder -> {})
                // ----------------------------------注入配置----------------------------------
                .injectionConfig(builder -> {
                    builder.beforeOutputFile(((tableInfo, objectMap) -> {
                                System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
                            })) // 输出文件之前消费者
//                            .customMap(Collections.singletonMap("test", "baomidou")) // 自定义配置 Map 对象
//                            .customFile(Collections.singletonMap("test.txt", "/templates/test.vm")) // 自定义配置模板文件
                            .build();
                })
                // ----------------------------------策略配置----------------------------------
                .strategyConfig(builder -> {
                    builder.enableCapitalMode() // 开启大写命名	默认值:false
                            .enableSkipView() // 开启跳过视图	默认值:false
                            .disableSqlFilter() // 禁用 sql 过滤	默认值:true，语法不能支持使用 sql 过滤表的话，可以考虑关闭此开关
                            .enableSchema() // 启用 schema	默认值:false，多 schema 场景的时候打开
//                            .likeTable(new LikeTable("USER")) // 模糊表匹配(sql 过滤)	likeTable 与 notLikeTable 只能配置一项
//                            .notLikeTable(new LikeTable("USER")) // 模糊表排除(sql 过滤)	likeTable 与 notLikeTable 只能配置一项
                            .addInclude(ADD_INCLUDE) // 增加表匹配(内存过滤)	include 与 exclude 只能配置一项
//                            .addExclude("a_abc") // 增加表排除匹配(内存过滤)	include 与 exclude 只能配置一项
                            .addTablePrefix(ADD_TABLE_PREFIX) // 增加过滤表前缀
//                            .addTableSuffix("abc") // 增加过滤表后缀
//                            .addFieldPrefix("sys_") // 增加过滤字段前缀
//                            .addFieldSuffix("_flag") // 增加过滤字段后缀
                            // ----------------------------------Entity 策略配置----------------------------------
                            .entityBuilder().superClass(BaseEntity.class) // 设置父类
//                            .disableSerialVersionUID() // 禁用生成 serialVersionUID 默认值:true
//                            .enableColumnConstant() // 开启生成字段常量	默认值:false
                            .enableChainModel() // 开启链式模型	默认值:false
//                            .enableLombok() // 开启 lombok 模型	默认值:false
                            .enableRemoveIsPrefix() // 开启 Boolean 类型字段移除 is 前缀	默认值:false
                            .enableTableFieldAnnotation() // 开启生成实体时生成字段注解	默认值:false
                            .enableActiveRecord() // 开启 ActiveRecord 模型	默认值:false
                            .versionColumnName("version") // 乐观锁字段名(数据库)
                            .versionPropertyName("version") // 乐观锁属性名(实体)
                            .logicDeleteColumnName("delete_flag") // 逻辑删除字段名(数据库)
                            .logicDeletePropertyName("deleteFlag") // 逻辑删除属性名(实体)
//                            .naming(NamingStrategy.no_change) // 数据库表映射到实体的命名策略	默认下划线转驼峰命名:NamingStrategy.underline_to_camel
//                            .columnNaming(NamingStrategy.underline_to_camel) // 数据库表字段映射到实体的命名策略	默认为 null，未指定按照 naming 执行
                            .addSuperEntityColumns("id", "delete_flag", "version", "created_by", "created_time", "updated_by", "updated_time") // 添加父类公共字段
//                            .addIgnoreColumns("age") // 添加忽略字段
                            .addTableFills(new Column("create_time", FieldFill.INSERT)) // 添加表字段填充
                            .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE)) // 添加表字段填充
                            .idType(IdType.ASSIGN_UUID) // 全局主键类型
//                            .formatFileName("%sEntity") // 格式化文件名称
                            .build()
                            // ----------------------------------Controller 策略配置----------------------------------
                            .controllerBuilder()
                            .superClass(BaseController.class) // 设置父类
                            .enableHyphenStyle() // 开启驼峰转连字符
                            .enableRestStyle() // 开启生成@RestController 控制器
//                            .convertFileName() // 转换文件名称
                            .formatFileName("%sController") // 格式化文件名称
                            .build()
                            // ----------------------------------Service 策略配置----------------------------------
                            .serviceBuilder()
                            .superServiceClass(BaseService.class) // 设置 service 接口父类
                            .superServiceImplClass(BaseServiceImpl.class) // 设置 service 实现类父类
//                            .convertServiceFileName() // 转换 service 接口文件名称
//                            .convertServiceImplFileName() // 转换 service 实现类文件名称
                            .formatServiceFileName("I%sService") // 格式化 service 接口文件名称
                            .formatServiceImplFileName("%sServiceImpl") // 格式化 service 实现类文件名称
                            .build()
                            // ----------------------------------Mapper 策略配置----------------------------------
                            .mapperBuilder()
                            .superClass(BaseMapper.class) // 设置父类
                            .enableMapperAnnotation() // 开启 @Mapper 注解 默认值:false
                            .enableBaseResultMap() // 启用 BaseResultMap 生成
                            .enableBaseColumnList() // 启用 BaseColumnList
//                            .cache(MyMapperCache.class) // 设置缓存实现类
//                            .convertMapperFileName(ConverterFileName) // 转换 mapper 类文件名称
//                            .convertXmlFileName(ConverterFileName) // 转换 xml 文件名称
                            .formatMapperFileName("%sMapper") // 格式化 mapper 文件名称
                            .formatXmlFileName("%sXml") // 格式化 xml 实现类文件名称
                            .build();
                })
                // ----------------------------------自定义模版支持(DTO\VO等)配置----------------------------------
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
