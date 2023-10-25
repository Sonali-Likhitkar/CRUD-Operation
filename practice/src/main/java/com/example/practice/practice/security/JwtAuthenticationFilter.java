package com.example.practice.practice.security;

import com.example.practice.practice.serviceimpl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
  private Logger LOGGER = LoggerFactory.getLogger(OncePerRequestFilter.class);

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        String  requestHeader= request.getHeader("Authorization");
//        String username= null;
//        String jwtToken= null;
//
//        if(requestHeader !=null && requestHeader.startsWith("Bearer ")){
//
//            jwtToken = requestHeader.substring(7);
//            try{
//                username = this.jwtHelper.getUsernameFromToken(jwtToken);
//            }catch(IllegalArgumentException illegalArgumentException){
//                LOGGER.info("IllegalArgumentException while Fetching username ");
//                illegalArgumentException.printStackTrace();
//            }catch (ExpiredJwtException expiredJwtException){
//                LOGGER.info("Given Jwt token is expired ");
//                expiredJwtException.printStackTrace();
//            }catch (MalformedJwtException malformedJwtException){
//                LOGGER.info("Some Change has done in token !! Invaild Token");
//                malformedJwtException.printStackTrace();
//            }
//        }else{
//            LOGGER.info("Invalid Header Value .............  ! ");
//        }
//        if(username!= null && SecurityContextHolder.getContext().getAuthentication()==null){
//            //fetch User details from username
//            UserDetails userDetails= userDetailsService.loadUserByUsername(username);
//            Boolean validateToken = jwtHelper.validateToken(jwtToken,userDetails);
//            if(validateToken){
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }else{
//             LOGGER.info("Validation Fails.....!!!");
//            }
//        }
//        filterChain.doFilter(request,response);
//    }

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
