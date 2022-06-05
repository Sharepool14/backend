package mau.project.sharepool.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * @author Hugo Lindstedt
 * Class that checks authorization before a user tries to access an endpoint resource.
 */
public class AuthorizationFilter extends OncePerRequestFilter {
    public AuthorizationFilter() {

    }

    @Override
    protected void doFilterInternal(
              HttpServletRequest request,
              HttpServletResponse response,
              FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/login")) {
            filterChain.doFilter(request,response);
        } else {
            String authHeader = request.getHeader(AUTHORIZATION);

            if (authHeader != null ) {

                try {
                    String token = authHeader.substring("Bearer ".length());
                    Algorithm algo = Algorithm.HMAC256("secret".getBytes());
                    JWTVerifier verify = JWT.require(algo).build();
                    DecodedJWT decode = verify.verify(token);

                    String username = decode.getSubject();
                    String[] roles = decode.getClaim("roles").asArray(String.class);
                    System.out.println(username);
                    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    stream(roles).forEach(role -> {
                        authorities.add(new SimpleGrantedAuthority(role));
                    });
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(username, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                filterChain.doFilter(request,response);
            }
        }
    }
}