package com.mj.codecreate.generator;

import cn.hutool.core.lang.Dict;
import cn.hutool.setting.yaml.YamlUtil;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.Map;


/**
 * MyBatis 代码生成器
 */
public class MyBatisGenerator {

    //  要生成的表名
    private static final String[] TABLE_NAMES = {"app"};

    public static void main(String[] args) {
        // 获取数据源信息
        Dict dict = YamlUtil.loadByPath("application.yaml");
        Map<String, Object> datasourceConfig = dict.getByPath("spring.datasource");
        String url = String.valueOf(datasourceConfig.get("url"));
        String username = String.valueOf(datasourceConfig.get("username"));
        String password = String.valueOf(datasourceConfig.get("password"));

        //配置数据源
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        //创建配置内容
        GlobalConfig globalConfig = createGlobalConfig();

        //通过 datasource 和 globalConfig 创建代码生成器
        Generator generator = new Generator(dataSource, globalConfig);

        //生成代码
        generator.generate();
    }


    public static GlobalConfig createGlobalConfig() {
        //创建配置内容
        GlobalConfig globalConfig = new GlobalConfig();

        //设置根包，建议先生成到临时目录下，生成代码之后在移动到对应的项目目录
        globalConfig.getPackageConfig()
                .setBasePackage("com.mj.codecreate.genresult");

        //设置表前缀和只生成哪些表，setGenerateTable 未配置时，生成所有表
        globalConfig.getStrategyConfig()
                .setGenerateTable(TABLE_NAMES)
                // 设置逻辑删除的默认字段名
                .setLogicDeleteColumn("isDelete");

        //设置生成 entity 并启用 Lombok
        globalConfig.enableEntity()
                .setWithLombok(true)
                .setJdkVersion(21);

        //设置生成 mapper
        globalConfig.enableMapper();
        //设置生成 mapper XML
        globalConfig.enableMapperXml();

        // 设置生成 Service
        globalConfig.enableService();
        globalConfig.enableServiceImpl();

        // 设置生成Controller
        globalConfig.enableController();

        // 设置生成注释
        globalConfig.getJavadocConfig()
                .setAuthor("<a href=\"https://github.com/Albert-MinJie-cloud\">MJ</a>")
                .setSince("");

        return globalConfig;
    }
}