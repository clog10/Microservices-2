package com.paymentchain.billing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.time.Duration;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private static final String[] NO_AUTH_LIST = {
            "/v3/api-docs", //
            "/configuration/ui", //
            "/swagger-resources", //
            "/configuration/security", //
            "/webjars/**", //
            "/login",
            "/h2-console/**" };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(withDefaults())
                .formLogin(withDefaults());
        return http.build();

        // 02- Custom security configuration, we can excluse some paths and ask by user
        // and password before each request to acces swagger ui
        // http.csrf().disable()
        // .authorizeHttpRequests((authz) -> authz
        // .requestMatchers(NO_AUTH_LIST).permitAll()
        // .requestMatchers(HttpMethod.POST, "/*billing*/**").authenticated()
        // // set whne user is authetnticate
        // .requestMatchers(HttpMethod.GET, "/*billing*/**").hasRole("ADMIN"))
        // .httpBasic(withDefaults())
        // // //use default UI.
        // .formLogin(withDefaults());
        // return http.build();

    }

    // @Bean
    // CorsConfigurationSource corsConfigurationSource() {
    // CorsConfiguration cc = new CorsConfiguration();

    // cc.setAllowedHeaders(Arrays.asList("Origin,Accept", "X-Requested-With",
    // "Content-Type",
    // "Access-Control-Request-Method", "Access-Control-Request-Headers",
    // "Authorization"));
    // cc.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin",
    // "Access-Control-Allow-Credentials"));

    // cc.setAllowedOrigins(Arrays.asList("/*"));

    // cc.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT",
    // "PATCH"));

    // cc.addAllowedOriginPattern("*");

    // cc.setMaxAge(Duration.ZERO);
    // cc.setAllowCredentials(Boolean.TRUE);
    // UrlBasedCorsConfigurationSource source = new
    // UrlBasedCorsConfigurationSource();
    // source.registerCorsConfiguration("/**", cc);
    // return source;
    // }

}
