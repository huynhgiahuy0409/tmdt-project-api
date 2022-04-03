package com.javatpoint.ecormspringboot.config.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SercurityConfigure extends WebSecurityConfigurerAdapter {

	@Bean
	@Override
//	Method userDetailsService() có tác dụng cung cấp thông tin user cho Spring Security
	protected UserDetailsService userDetailsService() {
		// Tạo ra user trong bộ nhớ
		// lưu ý, chỉ sử dụng cách này để minh họa
		// Còn thực tế chúng ta sẽ kiểm tra user trong csdl
		// TODO Auto-generated method stub
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		inMemoryUserDetailsManager.createUser(User.withUsername("huynhgiahuy").password("123").roles("USER").build());
		return inMemoryUserDetailsManager;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
//	Thực hiện việc phân quyền
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.csrf().disable();
	}

}
