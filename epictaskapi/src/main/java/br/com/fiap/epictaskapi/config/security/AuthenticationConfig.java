package br.com.fiap.epictaskapi.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class AuthenticationConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/user").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/user/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/user/**").permitAll()
                // .anyRequest().denyAll()
                .and().csrf().disable();

        return http.build();
    }
    // ----Tentativa---- :(
    // @Bean
    // public UserDetailsService users() {
    // UserDetails user = User.builder()
    // .username("admin@fiap.com.br")
    // .password(passwordEncoder().encode("administrador"))
    // .roles("ADMIN")
    // .build();

    // return new InMemoryUserDetailsManager(user);
    // }

    // @Bean
    // public PasswordEncoder passwordEncoder() {
    // return new BCryptPasswordEncoder();
    // }

}
