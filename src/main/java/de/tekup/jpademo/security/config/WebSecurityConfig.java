package de.tekup.jpademo.security.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig  {

    private UserDetailsService bdUserDetailsService;

    private PasswordEncoder bCryptPasswordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/signin", "/signup", "/css/**", "/js/**", "/fonts/**", "/images/**", "/scss/**", "/voitures-photos/**")
                .permitAll()
                .antMatchers("/clients/ui/**", "/voitures/ui/add").hasRole("ADMIN")
                .antMatchers("/voitures/ui/**").hasRole("USER")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/signin")
                .defaultSuccessUrl("/")
                .and().logout().logoutSuccessUrl("/")
                .and().userDetailsService(bdUserDetailsService)
                .build();

    }


}
