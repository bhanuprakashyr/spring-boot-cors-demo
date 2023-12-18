package com.example.springbootcorsdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Value("${website.cors.allowed.origins}")
    private List<String> allowedOrigins;

    @Value("${website.cors.allowed.methods}")
    private List<String> allowedMethods;

    @Value("${website.cors.allowed.headers}")
    private List<String> allowedHeaders;

    @Value("${website.cors.allowed.urlPatterns}")
    private String allowedUrlPatters;

    @Value("${website.user.name}")
    private String userName;

    @Value("${website.user.password}")
    private String userPassword;

    @Value("#{new Boolean('${website.allow.cors}')}")
    private Boolean allowCors;

    @Value("#{new Long('${website.allow.cors.inSeconds}')}")
    private Long allowTillInSeconds;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults()).cors((cors) -> cors.configurationSource(corsConfigurationSource()))
                .formLogin(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username(userName)
                .password(userPassword)
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    CorsConfigurationSource corsConfigurationSource() {
        if (allowCors) {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(allowedOrigins);
            configuration.setAllowedMethods(allowedMethods);
            configuration.setAllowedHeaders(allowedHeaders);
            configuration.setMaxAge(allowTillInSeconds);
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration(allowedUrlPatters, configuration);
            return source;
        } else {
            return new UrlBasedCorsConfigurationSource();
        }
    }

}
