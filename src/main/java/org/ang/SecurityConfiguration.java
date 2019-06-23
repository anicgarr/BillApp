package org.ang;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

@Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	 @Autowired
	 private DataSource dataSource;
	 
	 private final String USERS_QUERY = "select email, password, active from user where email=?";
	 private final String ROLES_QUERY = "select u.email, r.role from user u inner join user_role ur on (u.id = ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.email=?";

	 protected void configure(AuthenticationManager auth) throws Exception {
	  auth.jdbcAuthentication()
	   .usersByUsernameQuery(USERS_QUERY)
	   .authoritiesByUsernameQuery(ROLES_QUERY)
	   .dataSource(dataSource)
	   .passwordEncoder(bCryptPasswordEncoder);
	 }
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception{
	  http.authorizeRequests()
	   .antMatchers("/").permitAll()
	   .antMatchers("/login").permitAll()
	   .antMatchers("/signup").permitAll()
	   .antMatchers("/index").hasAuthority("ADMIN").anyRequest()
	   .authenticated().and().csrf().disable()
	   .formLogin().loginPage("/login").failureUrl("/login?error=true")
	   .defaultSuccessUrl("/index")
	   .usernameParameter("email")
	   .passwordParameter("password")
	   .and().logout()
	   .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	   .logoutSuccessUrl("/")
	   .and().rememberMe()
	   .tokenRepository(persistentTokenRepository())
	   .tokenValiditySeconds(60*60)
	   .and().exceptionHandling().accessDeniedPage("/access_denied");
	 }
	 
	 @Bean
	 public PersistentTokenRepository persistentTokenRepository() {
	  JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
	  db.setDataSource(dataSource);
	  
	  return db;
	 }
	 
	 @Bean
	 public UserService userService() {
	     return new UserServiceImpl();
	 }
	
	
}
