package com.sist.ex0905_dept.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.sist.ex0905_dept.mapper") //deptmapper의 위치
public class DbConfig {
    //자동으로 스프링 환경이 호출

    @Bean
    public SqlSessionFactory sqlSessionFactory(
            DataSource ds)throws Exception{
        //위의 @Bean이라고 명시했기 때문에 빈객체를 만들기 위해 한번 호출함!
        //SqlSessionFactoryt를 생성하는 객체를 만들자
        SqlSessionFactoryBean sBean = new SqlSessionFactoryBean();

        sBean.setDataSource(ds);

        //SQL문장들 (mapp)를 인식하기 위해 mapper들이 있는 위치를 지정하자!
        PathMatchingResourcePatternResolver resolver =
                new PathMatchingResourcePatternResolver();
        sBean.setMapperLocations(resolver.getResources(
                "classpath:mybatis/mapper/**/*.xml"));

        return sBean.getObject();
    }

    //인자로 SqlSessionFactory factory를 받음
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }
}
