package com.javatpoint.ecormspringboot.common.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.javatpoint.ecormspringboot.common.util.constance.SystemContance;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class JWTUtil {

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		Collection<? extends GrantedAuthority> roles = userDetails.getAuthorities();
		if (roles.contains(new SimpleGrantedAuthority("CUSTOMER"))) {
			claims.put("isCUSTOMER", true);
		}
		if (roles.contains(new SimpleGrantedAuthority("SUPPER USER"))) {
			claims.put("isSUPPERUSER", true);
		}
		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		System.out.println("JwtUtil doGenerateToken");
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + SystemContance.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SystemContance.SECREC).compact();
	}

	public boolean validateToken(String authToken) {
		System.out.println("JwtUtil validateToken");
		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(SystemContance.SECREC).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
			throw new BadCredentialsException("INVALID_CREDENTIALS", ex);
		}
	}

	public String getUsernameFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(SystemContance.SECREC).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public Date getExpirationDateFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(SystemContance.SECREC).parseClaimsJws(token).getBody();
		return claims.getExpiration();
	}

	public List<SimpleGrantedAuthority> getRolesFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(SystemContance.SECREC).parseClaimsJws(token).getBody();
		List<SimpleGrantedAuthority> roles = null;

		Boolean isCUSTOMER = claims.get("isCUSTOMER", Boolean.class);
		Boolean isSUPPERUSER = claims.get("isSUPPERUSER", Boolean.class);

		if (isCUSTOMER != null && isCUSTOMER) {
			roles = Arrays.asList(new SimpleGrantedAuthority("CUSTOMER"), new SimpleGrantedAuthority("READ"));
		}

		if (isSUPPERUSER != null && isSUPPERUSER) {
			roles = Arrays.asList(new SimpleGrantedAuthority("READ"), new SimpleGrantedAuthority("UPDATE"),
					new SimpleGrantedAuthority("DELETE"), new SimpleGrantedAuthority("CREATE"));
		}
		return roles;
	}
}
