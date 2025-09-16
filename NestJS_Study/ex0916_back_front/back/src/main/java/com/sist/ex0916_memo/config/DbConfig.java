package com.sist.ex0916_memo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages="com.sist.ex0916_memo.mapper")
public class DbConfig {
    @Bean
    public SqlSessionFactory getFactory(DataSource ds) throws Exception{

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);

        //Sql매퍼들을 지정하자
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        factoryBean.setMapperLocations(
        resolver.getResources("classpath:mapper/**/*.xml")
);
            return  factoryBean.getObject();
    }
    @Bean
    public SqlSessionTemplate gTemplate(SqlSessionFactory factory){
        return  new SqlSessionTemplate(factory);
    }
}
