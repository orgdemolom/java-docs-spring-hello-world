package com.example.demo.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "UserController", description = "Operaciones de usuario", tags = "Obtener Token")
public class UserController {
	@PostMapping("/user")
	@ApiOperation(value = "Iniciar sesión", notes = "Este endpoint permite iniciar sesión en la aplicación")
	public ResponseEntity<User> login(@ApiParam(value = "Nombre de usuario", required = true) @RequestParam("user") String username, @ApiParam(value = "Contraseña", required = true) @RequestParam("password") String pwd) {
		System.out.print(username + " " + pwd);

    	if(username.equals("usuario") && pwd.equals("Pa$$w0rd1")){
            String token = getJWTToken(username);
            User user = new User();
            user.setUser(username);
            user.setToken(token);		

            return ResponseEntity.status(HttpStatus.OK).body(user);  

        }else{
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);   
        }
        
    }

    private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
