package com.clinic.clinic.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private MyDatabaseUserDetailsService myDatabaseUserDetailsService;

    /*
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
    }*/

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(myDatabaseUserDetailsService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(myDatabaseUserDetailsService);
        //auth.authenticationProvider()
        //auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }*/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable()
                .cors().and()
                .authorizeRequests((auth)-> auth

                        .anyRequest().permitAll()
                )
                .formLogin().disable()
                .httpBasic();

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(myDatabaseUserDetailsService);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
/*.antMatchers(
        URLSecurityConstant.SECURITY_VALIDATE,
        URLSecurityConstant.SECURITY_SIGNUP,
        URLSecurityConstant.SECURITY_LOGIN,
        URLStaticResourceConstant.RESOURCE_APPOINTMENT_STATES,
        URLStaticResourceConstant.RESOURCE_ROLES
        ).permitAll()
        .antMatchers(
        HttpMethod.GET,
        URLResourceConstant.RESOURCE_SHIFTS+"/**",
        URLResourceConstant.RESOURCE_SERVICES_HEALTH,
        URLResourceConstant.RESOURCE_HEALTH_PERSONNEL,
        URLResourceConstant.RESOURCE_CONSULTING_ROOMS
        ).hasAnyRole(
        RoleConstant.RRHH.getEn(),
        RoleConstant.HEALT_PERSONNEL.getEn(),
        RoleConstant.ADMIN.getEn(),
        RoleConstant.PATIENT.getEn()
        )
        .antMatchers(
        URLResourceConstant.RESOURCE_SHIFTS,
        URLResourceConstant.RESOURCE_SERVICES_HEALTH,
        URLResourceConstant.RESOURCE_HEALTH_PERSONNEL,
        URLResourceConstant.RESOURCE_CONSULTING_ROOMS
        ).hasRole(
        RoleConstant.ADMIN.getEn()
        )*/