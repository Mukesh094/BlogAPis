package com.blog.blogger.config;

import com.blog.blogger.security.CustomUserDetailsService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").permitAll()//for Post,Put,Delete
                .antMatchers(HttpMethod.POST, "/api/auth/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }

    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//
//
//        //Object's Consiting of UserName & Password
//        UserDetails user = User.builder().username("Mukesh").password
//                (passwordEncoder.encode("test")).roles("USER").build();
//        UserDetails admin = User.builder().username("admin").password
//                (passwordEncoder.encode("admin")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user,admin);
//        //@PreAuthorize("hasROle('ADMIN')")
//        //After Adding this Annotation
//        //@EnableGlobalMethodSecurity(prePostEnabled=true)
//    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(getEncodedPassword());
    }
    @Bean
    public PasswordEncoder getEncodedPassword(){

        return new BCryptPasswordEncoder();
    }
}
