package com.az.model;

import lombok.*;

@Setter
@Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
    private Long id;
    private String name;
    private String email;
}
