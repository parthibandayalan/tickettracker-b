package com.tickettracker.tickettrackerb.controllers;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;

import com.tickettracker.tickettrackerb.model.AuthenticationRequest;
import com.tickettracker.tickettrackerb.service.MyUserDetailsService;
import com.tickettracker.tickettrackerb.util.JwtUtil;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	MyUserDetailsService userDetailsService;
	@Autowired
	JwtUtil jwtTokenUtil;

	@PostMapping("/authenticate")
	public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
			HttpServletResponse res) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

//		Cookie cookie = new Cookie("jwt", jwt);
//		cookie.setMaxAge(5*60);
//		cookie.setSecure(false);
//		cookie.setPath("/");
//		cookie.setHttpOnly(true);		
//
//		res.addCookie(cookie);	
		
		res.setStatus(HttpServletResponse.SC_OK);
		
		res.setContentType("application/json");
		
		ResponseCookie cookie = ResponseCookie.from("jwt", jwt)
	            .maxAge(30*60)	            
	            .sameSite("None")
	            .secure(true)
	            .path("/")
	            .build();
		res.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
		
		// Get the printwriter object from response to write the required json object to the output stream      
		
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		
		String jsonObject = "{ \"Roles\":\"" + userDetails.getAuthorities().toString() + "\"}";
		
		res.getWriter().write(jsonObject.toString());
		res.getWriter().flush();

		return;
	}
	
	@PostMapping("/refreshtoken")
	public void refreshToken(HttpServletRequest request,HttpServletResponse res) {
		
		//final String authorizationHeader = request.getHeader("Authorization");
		
		String username = null;
		String jwt = null;
		Cookie cookieJwt = null;
		
		
		
		if(WebUtils.getCookie(request, "jwt") != null ) {
			cookieJwt = WebUtils.getCookie(request, "jwt");
			jwt = cookieJwt.getValue();
			username = jwtTokenUtil.extractUsername(jwt);
		}
		
		Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
		logger.info("Cookie read : " + cookieJwt.getValue().toString() + "Username : "+username);
		
		if (username != null && jwtTokenUtil.canTokenBeRefreshed(jwt)) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			logger.info("username received"+userDetails.getUsername());
			if (jwtTokenUtil.validateToken(jwt, userDetails)) {

				String refreshedToken = jwtTokenUtil.refreshToken(jwt);
				
//				Cookie cookie = new Cookie("jwt", refreshedToken);
//				cookie.setMaxAge(5*60);
//				cookie.setSecure(false);
//				cookie.setPath("/");
//				cookie.setHttpOnly(true);
//				
//				logger.info("Cookie refreshed : " + cookie.toString());
//
//				res.addCookie(cookie);
				
				ResponseCookie cookie = ResponseCookie.from("jwt", jwt)
			            .maxAge(30*60)	            
			            .sameSite("None")
			            .secure(true)
			            .path("/")
			            .build();
				res.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
				
				return;
				/*UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);*/
			} else {
				logger.info("Token Invalid");
			}
		}
	}
	
	@PostMapping("/canceltoken")
	public void logoutToken(HttpServletRequest request,HttpServletResponse res) {
		String username = null;
		String jwt = null;
		Cookie cookieJwt = null;
		
		if(WebUtils.getCookie(request, "jwt") != null ) {
			cookieJwt = WebUtils.getCookie(request, "jwt");
			jwt = cookieJwt.getValue();
			username = jwtTokenUtil.extractUsername(jwt);
		}
		
		Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
		logger.info("Cookie read : " + cookieJwt.getValue().toString() + "Username : "+username);
		
		if (username != null && jwtTokenUtil.canTokenBeRefreshed(jwt)) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			
			if (jwtTokenUtil.validateToken(jwt, userDetails)) {

				String refreshedToken = jwtTokenUtil.refreshToken(jwt);
				
//				Cookie cookie = new Cookie("jwt", refreshedToken);
//				cookie.setMaxAge(0);
//				cookie.setSecure(false);
//				cookie.setPath("/");
//				cookie.setHttpOnly(true);
//				
//				//logger.info("Cookie refreshed : " + cookie.toString());
//
//				res.addCookie(cookie);
				
				ResponseCookie cookie = ResponseCookie.from("jwt", jwt)
			            .maxAge(30*60)	            
			            .sameSite("None")
			            .secure(true)
			            .path("/")
			            .build();
				res.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
				
				return;
				/*UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);*/
			} else {
				logger.info("Token Invalid");
			}
		}
		
		
	}

}
