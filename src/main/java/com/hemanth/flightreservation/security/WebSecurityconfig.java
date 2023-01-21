//package com.hemanth.flightreservation.security;
//
//import org.springframework.context.annotation.Bean;
////import org.springframework.security.authentication.AuthenticationManager;
////import org.springframework.security.config.BeanIds;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
////@Configuration
////@EnableWebSecurity
//public class WebSecurityconfig extends WebSecurityConfigurerAdapter{
//
//	@Bean
//	public BCryptPasswordEncoder bCryptPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests().antMatchers("/","/showReg","/showLogin","/registerUser","/login")
//						.permitAll()
//						.antMatchers("/admin/*").hasAnyAuthority("ADMIN").anyRequest().authenticated().and()
//						.csrf().disable();
//	}
//	
//	@Bean(name=BeanIds.AUTHENTICATION_MANAGER)
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		// TODO Auto-generated method stub
//		return super.authenticationManagerBean();
//	}
//}
