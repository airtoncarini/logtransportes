package br.com.logtransportes.controle_viagem.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.logtransportes.controle_viagem.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${token.jwt.expiration}")
	private String expiration;
	
	@Value("${token.jwt.secret}")
	private String secret;
	
	public String generateToken(Authentication authentication) {
		Usuario logado = (Usuario) authentication.getPrincipal();
		Date dtHoje = new Date();
		Date dtExp = new Date(dtHoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("API")
				.setSubject(logado.getId().toString())
				.setIssuedAt(dtHoje)
				.setExpiration(dtExp)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isValidToken(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;	
		} catch (Exception e) {
			return false;
		}
	}

	public Long getUserId(String token) {
		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(body.getSubject());
	}

}
