package io.security.springsecuritymaster.security.config;

import io.security.springsecuritymaster.security.handler.FormAuthenticationFailureHandler;
import io.security.springsecuritymaster.security.handler.FormAuthenticationSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final FormAuthenticationSuccessHandler formAuthenticationSuccessHandler;
    private final FormAuthenticationFailureHandler formAuthenticationFailureHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/images", "/js/**", "/favicon.*", "/*/icon-*").permitAll()
                        .requestMatchers("/", "signup", "login*").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginPage("/login")
                        .successHandler(formAuthenticationSuccessHandler)
                        .failureHandler(formAuthenticationFailureHandler)
                        .permitAll()
                )
                // user details service 보다 authentication provider가 더 넓은 범위의 작업을 수행함.
                // authentication provider 인증을 수행하는 실질적인 로직을 모두 가지고 있음
//                .userDetailsService(userDetailsService);
                .authenticationProvider(authenticationProvider);
        return http.build();
    }

}
