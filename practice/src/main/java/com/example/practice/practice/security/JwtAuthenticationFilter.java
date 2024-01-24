package com.example.practice.practice.security;

import com.example.practice.practice.serviceimpl.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private final Logger LOGGER = LoggerFactory.getLogger(OncePerRequestFilter.class);


    private final JwtHelper jwtHelper;

    private final UserDetailsServiceImpl userDetailsService;


    public JwtAuthenticationFilter(JwtHelper jwtHelper,UserDetailsServiceImpl userDetailsService){
        this.jwtHelper=jwtHelper;
        this.userDetailsService =userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String requestTokenHeader=request.getHeader("Authorization");
        String email = null;
        String jwtToken = null;
        if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
        {
            jwtToken =requestTokenHeader.substring(7);
            LOGGER.info(String.format("jwtToken: %s", jwtToken));
            email= jwtHelper.extractUsername(jwtToken);
        }
        else {
            LOGGER.info("Invalid Token, not start with Bearer String..!!");
        }
        if(email != null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
            if(this.jwtHelper.validateToken(jwtToken,userDetails)) {
                LOGGER.info("Token is valid for email: {}", email);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
            else{
                LOGGER.info("Token is not valid for email: {}", email);
            }
        }
        filterChain.doFilter(request, response);
    }
}
