package com.albert.learn.security.serivce;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) {
        if (StringUtils.hasText(userName)) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_root"));
            return new User(userName, new BCryptPasswordEncoder().encode("123456"), authorities);

        } else {
            throw new UsernameNotFoundException("Cannot pass null or empty values to userName");
        }
    }
}
