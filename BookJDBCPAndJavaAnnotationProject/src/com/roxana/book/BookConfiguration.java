package com.roxana.book;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.roxana.persistence.BookDao;
import com.roxana.persistence.BookDaoImpl;

@Configuration
@ComponentScan(basePackages = "com.roxana")
public class BookConfiguration {
	
	public class SpringJDBCConfiguration {
		
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/wileydi001");
	        dataSource.setUsername("root");
	        dataSource.setPassword("Manolescu91.");
	        return dataSource;
	          }
	    
        @Bean
        public JdbcTemplate jdbcTemplate() {
          JdbcTemplate jdbcTemplate = new JdbcTemplate();
          jdbcTemplate.setDataSource(dataSource());
          return jdbcTemplate;
        }

	      }
}
