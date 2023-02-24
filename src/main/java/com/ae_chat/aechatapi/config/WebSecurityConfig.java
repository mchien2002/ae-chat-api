// package com.ae_chat.aechatapi.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.ae_chat.aechatapi.component.JwtRequestFilter;
// import com.ae_chat.aechatapi.route.RouteConstant;

// @Configuration
// @EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//     @Autowired
//     private JwtRequestFilter jwtRequestFilter;

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.csrf().disable().authorizeHttpRequests()
//                 .antMatchers(RouteConstant.VERIFY_OTP_EMAIL, RouteConstant.REGISTER_EMAIL,
//                         RouteConstant.VERIFY_OTP_MOBILE, RouteConstant.REGISTER_MOBILE, "/",
//                         RouteConstant.IMAGE_URL + "/**")
//                 .permitAll().anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()
//                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//         http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return NoOpPasswordEncoder.getInstance();
//     }
// }
