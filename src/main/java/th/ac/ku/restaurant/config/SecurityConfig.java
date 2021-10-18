package th.ac.ku.restaurant.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //มีการ login ก่อน
                .antMatchers("/","/css/**","/js/**").permitAll() //สามารถเข้าถึงอะไรได้บ้าง
                .anyRequest().authenticated()
        .and()
                .oauth2Login()
                .defaultSuccessUrl("/").permitAll()
        .and()
                .logout()
                .logoutSuccessUrl("/").permitAll();
    }

}
