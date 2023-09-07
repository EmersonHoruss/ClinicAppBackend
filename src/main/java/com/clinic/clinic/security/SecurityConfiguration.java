package com.clinic.clinic.security;

import com.clinic.clinic.constants.URLs.URLResourceConstant;
import com.clinic.clinic.constants.URLs.URLSecurityConstant;
import com.clinic.clinic.constants.URLs.URLStaticResourceConstant;
import com.clinic.clinic.constants.staticResources.RoleConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
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
    private HttpSecurity http;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        this.http = http;
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
                )
                .formLogin().disable()
                .httpBasic();
        secureResourceAppointments();
        secureResourceClinic();
        secureResourceConsultingRooms();
        secureResourceHealthPersonnel();
        secureResourcePatients();
        secureResourceSchedules();
        secureResourceServicesHealth();
        secureResourceShifts();
        secureResourceUsers();
        return http.build();
    }

    private void secureResourceAppointments() throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, URLResourceConstant.RESOURCE_APPOINTMENTS+"/**")
                .hasAnyRole(
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                )
                .antMatchers(HttpMethod.POST, URLResourceConstant.RESOURCE_APPOINTMENTS)
                .hasAnyRole(
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                )
                .antMatchers(HttpMethod.PUT, URLResourceConstant.RESOURCE_APPOINTMENTS)
                .hasAnyRole(
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                )
                .antMatchers(HttpMethod.DELETE, URLResourceConstant.RESOURCE_APPOINTMENTS)
                .hasAnyRole(
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                );
    }

    private void secureResourceClinic() throws Exception {
        http.authorizeRequests()
                .antMatchers(URLResourceConstant.RESOURCE_CLINICS)
                .hasRole(RoleConstant.ADMIN.getEn());
    }

    private void secureResourceConsultingRooms() throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, URLResourceConstant.RESOURCE_CONSULTING_ROOMS+"/**")
                .hasAnyRole(
                        RoleConstant.RRHH.getEn(),
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                )
                .antMatchers(HttpMethod.POST, URLResourceConstant.RESOURCE_CONSULTING_ROOMS)
                .hasRole(RoleConstant.ADMIN.getEn())
                .antMatchers(HttpMethod.PUT, URLResourceConstant.RESOURCE_CONSULTING_ROOMS)
                .hasRole(RoleConstant.ADMIN.getEn())
                .antMatchers(HttpMethod.DELETE, URLResourceConstant.RESOURCE_CONSULTING_ROOMS)
                .hasRole(RoleConstant.ADMIN.getEn());
    }

    private void secureResourceHealthPersonnel() throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, URLResourceConstant.RESOURCE_HEALTH_PERSONNEL+"/**")
                .hasAnyRole(
                        RoleConstant.RRHH.getEn(),
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                )
                .antMatchers(HttpMethod.POST, URLResourceConstant.RESOURCE_HEALTH_PERSONNEL)
                .hasRole(RoleConstant.ADMIN.getEn())
                .antMatchers(HttpMethod.PUT, URLResourceConstant.RESOURCE_HEALTH_PERSONNEL)
                .hasRole(RoleConstant.ADMIN.getEn())
                .antMatchers(HttpMethod.DELETE, URLResourceConstant.RESOURCE_HEALTH_PERSONNEL)
                .hasRole(RoleConstant.ADMIN.getEn());
    }

    private void secureResourcePatients() throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.DELETE, URLResourceConstant.RESOURCE_PATIENTS)
                .hasAnyRole(RoleConstant.ADMIN.getEn())
                .antMatchers(URLResourceConstant.RESOURCE_PATIENTS)
                .hasAnyRole(
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                );
    }

    private void secureResourceSchedules() throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, URLResourceConstant.RESOURCE_SCHEDULES+"/**")
                .hasAnyRole(
                        RoleConstant.RRHH.getEn(),
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                )
                .antMatchers(HttpMethod.POST, URLResourceConstant.RESOURCE_SCHEDULES)
                .hasAnyRole(
                        RoleConstant.RRHH.getEn(),
                        RoleConstant.ADMIN.getEn()
                )
                .antMatchers(HttpMethod.PUT, URLResourceConstant.RESOURCE_SCHEDULES)
                .hasAnyRole(
                        RoleConstant.RRHH.getEn(),
                        RoleConstant.ADMIN.getEn()
                )
                .antMatchers(HttpMethod.DELETE, URLResourceConstant.RESOURCE_SCHEDULES)
                .hasAnyRole(
                        RoleConstant.RRHH.getEn(),
                        RoleConstant.ADMIN.getEn()
                );
    }

    private void secureResourceServicesHealth() throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, URLResourceConstant.RESOURCE_SERVICES_HEALTH+"/**")
                .hasAnyRole(
                        RoleConstant.RRHH.getEn(),
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                )
                .antMatchers(HttpMethod.POST, URLResourceConstant.RESOURCE_SERVICES_HEALTH)
                .hasRole(RoleConstant.ADMIN.getEn())
                .antMatchers(HttpMethod.PUT, URLResourceConstant.RESOURCE_SERVICES_HEALTH)
                .hasRole(RoleConstant.ADMIN.getEn())
                .antMatchers(HttpMethod.DELETE, URLResourceConstant.RESOURCE_SERVICES_HEALTH)
                .hasRole(RoleConstant.ADMIN.getEn());
    }

    private void secureResourceShifts() throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, URLResourceConstant.RESOURCE_SHIFTS+"/**")
                .hasAnyRole(
                        RoleConstant.RRHH.getEn(),
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                )
                .antMatchers(HttpMethod.POST, URLResourceConstant.RESOURCE_SHIFTS)
                .hasRole(RoleConstant.ADMIN.getEn())
                .antMatchers(HttpMethod.PUT, URLResourceConstant.RESOURCE_SHIFTS)
                .hasRole(RoleConstant.ADMIN.getEn())
                .antMatchers(HttpMethod.DELETE, URLResourceConstant.RESOURCE_SHIFTS)
                .hasRole(RoleConstant.ADMIN.getEn());
    }

    private void secureResourceUsers() throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, URLResourceConstant.RESOURCE_USERS+"/**")
                .hasAnyRole(
                        RoleConstant.RRHH.getEn(),
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                )
                .antMatchers(HttpMethod.POST, URLResourceConstant.RESOURCE_USERS)
                .hasAnyRole(RoleConstant.ADMIN.getEn())
                .antMatchers(HttpMethod.PUT, URLResourceConstant.RESOURCE_USERS)
                .hasAnyRole(
                        RoleConstant.RRHH.getEn(),
                        RoleConstant.HEALT_PERSONNEL.getEn(),
                        RoleConstant.ADMIN.getEn(),
                        RoleConstant.PATIENT.getEn()
                )
                .antMatchers(HttpMethod.DELETE, URLResourceConstant.RESOURCE_USERS)
                .hasAnyRole(RoleConstant.ADMIN.getEn());
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
