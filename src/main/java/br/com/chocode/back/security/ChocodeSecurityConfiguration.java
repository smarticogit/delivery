package br.com.chocode.back.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ChocodeSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private ChocodeEntryPoint entryPoint;
	
	public void configure(HttpSecurity httpSec) throws Exception{
		httpSec.csrf().disable()
					  .exceptionHandling().authenticationEntryPoint(entryPoint)   
					  .and()
					  .authorizeRequests() 

					  .antMatchers(HttpMethod.POST, "/entregadores/login").permitAll()
					  .antMatchers(HttpMethod.POST, "/entregadores").permitAll()
					  .antMatchers(HttpMethod.POST, "/clientes").permitAll()
					  .anyRequest().authenticated().and().cors();
		
		httpSec.addFilterBefore(new ChocodeFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}
}
