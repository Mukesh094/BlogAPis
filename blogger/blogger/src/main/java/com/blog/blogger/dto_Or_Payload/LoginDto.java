package com.blog.blogger.dto_Or_Payload;

import lombok.Data;

@Data
public class LoginDto {
private String UsernameOrEmail;
private String password;
}
