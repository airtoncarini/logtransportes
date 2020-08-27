package br.com.logtransportes.controle_viagem.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.logtransportes.controle_viagem.modelo.Usuario;
import br.com.logtransportes.controle_viagem.repository.UsuarioRepository;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	private UsuarioRepository usuarioRepository;
	
	public TokenAuthenticationFilter(TokenService tokenService,UsuarioRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = getToken(request);
		boolean isValidToken = tokenService.isValidToken(token);
		
		if (isValidToken)
			authenticateUser(token);

		filterChain.doFilter(request, response);
	}

	private void authenticateUser(String token) {
		Long userId = tokenService.getUserId(token);
		Usuario user = usuarioRepository.findById(userId).get();
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		
		if (header == null || header.isEmpty() || !header.startsWith("Bearer "))
			return null;
		
		return header.substring(7, header.length());
	}

}
