package com.albert.learn.security.repository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class MySecurityContextRepository implements SecurityContextRepository {
    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        HttpServletRequest request = requestResponseHolder.getRequest();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        String tokenHeader = request.getHeader(webApplicationContext.getEnvironment().getProperty("albert.security.token.header"));
        // redis get
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        if (tokenHeader == null) {
            return context;
        }
        context.setAuthentication(getAuthentication(tokenHeader));
        return context;
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String username = "";
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_root"));
        // 从Token中解密获取用户角色
//        Object o = redisTemplate.opsForValue().get(tokenHeader);
//        UserTokenModel userTokenModel = (UserTokenModel) o;
//        if (Objects.nonNull(userTokenModel)) {
//            username = userTokenModel.getUsername();
//            userTokenModel.getGrantedAuthorityList().forEach(temp -> authorities.add(new SimpleGrantedAuthority(temp)));
//        }
        return new UsernamePasswordAuthenticationToken(username, null, authorities);
    }

    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        //Authentication authentication = context.getAuthentication();
        // redis set
        request.setAttribute("token", "123");
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {

        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        String tokenHeader = request.getHeader(webApplicationContext.getEnvironment().getProperty("albert.security.token.header"));
        return StringUtils.hasText(tokenHeader);

    }
}
