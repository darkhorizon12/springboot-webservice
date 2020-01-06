package com.matey.bootwebservice.config.oauth;

import com.matey.bootwebservice.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 스프링 시큐리티 설정정보 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .headers().frameOptions().disable() // h2-console 사용하기 위해 해당 옵션 비활성화
            .and()
                .authorizeRequests() // url별 권한 관리 설정 옵션의 진입점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name()) // USER 권한을 가진 사용자에게만 허용
                .anyRequest().authenticated() // 그외는 인증된 사용자(로그인한)에게만 허용
            .and()
                .logout()
                    .logoutSuccessUrl("/")
            .and()
                .oauth2Login()
                    .userInfoEndpoint() // 로그인 성공이후 사용자 정보를 가져올 설정 담당
                        .userService(customOAuth2UserService); // UserService 인터페이스 구현체 등록.
    }
}
