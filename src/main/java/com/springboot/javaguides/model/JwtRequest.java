package com.springboot.javaguides.model;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class JwtRequest {
	private String email;
	private String password;
}
