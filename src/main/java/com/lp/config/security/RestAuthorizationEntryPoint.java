//RestAuthorizationEntryPoint
package com.lp.config.security;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lp.beans.pojo.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        Result result = Result.error("尚未登陆，请登录!");
        result.setCode(401);
        writer.write(new ObjectMapper().writeValueAsString(result));
        writer.flush();
        writer.close();
    }
}
