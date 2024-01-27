package com.hakathon.project.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Token {
    String userId;
    String token;
}
