package cn.tjsanshao.blogserver.config;

import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * security config
 *
 * @author TjSanshao
 * @date 2020-04-07 15:03
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private PasswordEncoder encoder;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("TjSanshao").roles("admin").password(encoder.encode("root"));
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/private/**").hasRole("admin").anyRequest().permitAll();
        http.httpBasic().authenticationEntryPoint((request, response, e) -> {
            HashMap<String, Object> res = new HashMap<>();
            res.put("statusCode", -9);
            res.put("errorMsg", "no permissions");
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(res));
            writer.flush();
            writer.close();
        });
        http.formLogin().permitAll().loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password")
                .successHandler((request, response, auth) -> {
                    HashMap<String, Object> res = new HashMap<>();
                    res.put("statusCode", 0);
                    res.put("errorMsg", "");
                    PrintWriter writer = response.getWriter();
                    writer.write(JSON.toJSONString(res));
                    writer.flush();
                    writer.close();
                })
                .failureHandler((request, response, e) -> {
                    HashMap<String, Object> res = new HashMap<>();
                    res.put("statusCode", -1);
                    res.put("errorMsg", "login fail");
                    PrintWriter writer = response.getWriter();
                    writer.write(JSON.toJSONString(res));
                    writer.flush();
                    writer.close();
                });
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/public/**");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
