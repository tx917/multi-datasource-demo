package com.jingai.multidatasource.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.jingai.multidatasource.test2.dao", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class Test2DataSourceConfig {

    @Bean("test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    @Primary
    public DataSource test2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("test2SqlSessionFactory")
    @Primary
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setConfiguration(new MybatisConfiguration());
        bean.setDataSource(dataSource);
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        bean.setPlugins(new Interceptor[]{mybatisPlusInterceptor});
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/test2/*.xml"));
        return bean.getObject();
    }

    @Bean("test2TransactionManager")
    @Primary
    public DataSourceTransactionManager test2TransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("test2SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate test2SqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
