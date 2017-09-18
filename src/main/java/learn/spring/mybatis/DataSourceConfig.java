package learn.spring.mybatis;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import learn.spring.mybatis.mapper.FestivalMapper;

@Configuration
public class DataSourceConfig {
	
	@Bean("dataSource")
	@ConfigurationProperties(prefix="app.datasource")
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
		
	}
	
	@Bean
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(getDataSource());
		return ssfb.getObject();
	}
	
	@Bean("festivalMapper")
	public MapperFactoryBean<FestivalMapper> getFestivalFactoryBean() throws Exception {
		MapperFactoryBean<FestivalMapper> mfb = new MapperFactoryBean<>();
		mfb.setSqlSessionFactory(getSqlSessionFactory());
		mfb.setMapperInterface(FestivalMapper.class);
		return mfb;
	}
}
