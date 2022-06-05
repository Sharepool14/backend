package mau.project.sharepool.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import mau.project.sharepool.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Hugo Lindstedt
 * Class for authenticating users againt the database. if authnetication is sucsessfull a JWT token is created and sent to
 * the user.
 */
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * Tries to authenticate against the database and check if passwords match.
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String username = null;
        String password = null;
        try {
            Map<String, String> requestMap = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            username = requestMap.get("username");
            password = requestMap.get("password");
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,password);
        } catch (IOException e) {
            e.printStackTrace();
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,password);
        return authenticationManager.authenticate(authToken);
    }

    /**
     * If password match a JWT token is generated and added to the http request.
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(
              HttpServletRequest request,
              HttpServletResponse response,
              FilterChain chain,
              Authentication authResult) throws IOException, ServletException {
        Account account = (Account) authResult.getPrincipal();
        Algorithm algo = Algorithm.HMAC256("secret".getBytes());
        String access_token = JWT.create()
                .withSubject(account.getId().toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + Integer.MAX_VALUE))
                .withIssuer("Share Pool")
                .withClaim("roles",account.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algo);

        String refresh_token = JWT.create()
                .withSubject(account.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10*60*2000))
                .withIssuer("Share Pool")
                .sign(algo);

        Map<String, String>  jsonResponse = new HashMap<>();

        jsonResponse.put("username",account.getUsername());
        jsonResponse.put("id",account.getId().toString());
        jsonResponse.put("access_token",access_token);
        jsonResponse.put("refresh_token",refresh_token);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), jsonResponse);
    }
}
