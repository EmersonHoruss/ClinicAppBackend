package com.giordy.giordy.security;

import com.giordy.giordy.constants.URLs.URLResourceConstant;
import com.giordy.giordy.constants.URLs.URLSecurityConstant;
import com.giordy.giordy.constants.URLs.URLStaticResourceConstant;
import com.giordy.giordy.constants.staticResources.RoleConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    private MyDatabaseUserDetailsService myDatabaseUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable()
                .cors().and()
                .authorizeRequests((auth)-> auth
                        .antMatchers(
                                URLSecurityConstant.SECURITY_VALIDATE,
                                URLSecurityConstant.SECURITY_SIGNUP,
                                URLSecurityConstant.SECURITY_LOGIN,
                                URLStaticResourceConstant.RESOURCE_APPOINTMENT_STATES,
                                URLStaticResourceConstant.RESOURCE_ROLES
                        ).permitAll()
                        .antMatchers(
                                URLResourceConstant.RESOURCE_SERVICES_HEALTH,
                                URLResourceConstant.RESOURCE_SERVICES_HEALTH + "/**"
                        ).hasAnyRole()

                        .anyRequest().authenticated()
                )
                .formLogin().disable()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(myDatabaseUserDetailsService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(myDatabaseUserDetailsService);
        //auth.authenticationProvider()
        //auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
