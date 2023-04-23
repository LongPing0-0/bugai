//SecurityConfig
package com.lp.config.security;
import com.lp.beans.entity.RoleEntity;
import com.lp.beans.entity.UserEntity;
import com.lp.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.ObjectUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.Arrays;
import java.util.List;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RestAuthorizationEntryPoint restAuthorizationEntryPoint;
    @Autowired RestFullAccessDeniedHandler restFullAccessDeniedHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/system/appUpdate",
                "/login",
                "/user/logout",
                "/user/add",
                "/user/register",
                "/user/forget",
                "/email/forget",
                "/email/register",
                "/logout",
                "/css/**",
                "/js/**",
                "/index.html",
                "favicon.ico",
                "/doc.html",
                "webjars/**",
                "/swagger-resources/**",
                "/v2/api-docs/**",
                "/vc.jpg",
                "/doc.html",
                "/webjars/**"
        );
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/login","/logout","/app/checkUpdate")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .cors().configurationSource(configurationSource()).and()
                .headers()
                .cacheControl();
        // jwt登录拦截器
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //未授权未登录
        http.exceptionHandling()
                .accessDeniedHandler(restFullAccessDeniedHandler)
                .authenticationEntryPoint(restAuthorizationEntryPoint);
    }
    @Override
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            UserEntity user = userMapper.selectUserByUsername(username);
            System.out.println("user: "+user);
            if (ObjectUtils.isEmpty(user)) throw new UsernameNotFoundException("用户不存在");
            List<RoleEntity> roleEntities = userMapper.selectRoleByUid(user.getUid());
            user.setRoles(roleEntities);
            System.out.println("查询到用户权限: ");
            System.out.println(user);
            return user;
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }
    CorsConfigurationSource configurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);
        return source;
    }
}
