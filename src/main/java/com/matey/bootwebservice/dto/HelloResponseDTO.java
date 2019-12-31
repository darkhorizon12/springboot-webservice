package com.matey.bootwebservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString(of = { "name", "amount" })
public class HelloResponseDTO {
    private final String name;
    private final int amount;
}
