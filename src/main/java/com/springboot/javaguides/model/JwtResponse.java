package com.springboot.javaguides.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JwtResponse {
	private String jwtToken;
	private String username;
}
