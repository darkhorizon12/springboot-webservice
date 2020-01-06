package com.matey.bootwebservice.domain;

import com.matey.bootwebservice.domain.user.Role;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    public void 이넘_테스트() {
        //given
        User user = User.builder()
                .name("name")
                .email("email")
                .picture("picture")
                .role(Role.GUEST)
                .build();

        //when
        String roleKey = user.getRoleKey();

        //then
        assertThat(roleKey).isEqualTo("ROLE_GUEST");
    }
}