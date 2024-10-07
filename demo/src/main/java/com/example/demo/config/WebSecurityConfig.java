package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

import com.example.demo.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity // 웹 보안을 활성화 하는데 사용한다.
//스프링 시큐리티 설정을 활성화
public class WebSecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	@Bean //bean을 직접 만드는 어노테이션
	protected DefaultSecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		
		//HttpSecurity 설정
		//웹 보안을 설정하는데 사용되는 클래스
		//빌더 패턴을 사용해서 인증,권한부여,csrf보호, 세션관리 등을 처리할 수 있다.
		http
			//WebMvcConfig 에서 cors설정을 했으므로 시큐리티에서는 비활성화
			.cors(corsConfigurer -> corsConfigurer.disable())
			//csrf : 사용자가 인증된 상태에서 공격자가 악의적으로 요청을 보내 사용자의 권한을 악용하는 공격기법
			//API 서버가 클라이언트에서 Rest요청을 받을 때 CSRF보호가 불필요할 수 있다.
			.csrf(csrfConfigurer -> csrfConfigurer.disable())
			//JWT를 사용하므로 Basic인증은 비활성화
			.httpBasic(httpBasicConfigurer -> httpBasicConfigurer.disable())
			//세션을 사용하지 않는다.
			//sessionCreationPolicy() : 세션 정책을 설정하는 메서드
			//SessionCreationPolicy.STATELESS : 세션을 생성하지 않고 stateless방식으로 동작하도록 설정
			.sessionManagement(sessionManagementConfigurer -> sessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			//요청에 대한 인증/인가 설정
			.authorizeHttpRequests(authorizeRequestsConfigurer -> authorizeRequestsConfigurer.requestMatchers("/","/auth/**").permitAll()//특정 경로는 인증없이 허용
					.anyRequest().authenticated());//나머지 요청에 대해서는 인증 필요
		
		//filter등록
		//CorsFilter 를 실행한 후
		//jwt인증 필터를 실행하겠다.
		http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);
		
		return http.build();
	}

}
