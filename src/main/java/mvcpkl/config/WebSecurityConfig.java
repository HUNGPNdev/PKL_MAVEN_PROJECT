package mvcpkl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//   @Override
//   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//      auth.inMemoryAuthentication()
//         .withUser("sunil").password("pass123").roles("USER")
//         .and()
//         .withUser("admin").password("pass123").roles("ADMIN");
//   }

   @Autowired
   UserDetailsService userDetailsService;

   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   };

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
   }

   @Bean
   public DaoAuthenticationProvider daoAuthenticationProvider(){
      DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
      provider.setUserDetailsService(userDetailsService);
      provider.setPasswordEncoder(passwordEncoder());
      return provider;
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable().authorizeRequests()
              .antMatchers("/admin/**").hasRole("ADMIN")
              .antMatchers("/pkl/**").permitAll()
              .antMatchers("/account/**").permitAll()
      .antMatchers("/test/user**").hasRole("USER")
      .antMatchers("/test/admin**").hasRole("ADMIN")
      .and()
      .formLogin().loginPage("/login").permitAll()
      .and()
      .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
   }


}
