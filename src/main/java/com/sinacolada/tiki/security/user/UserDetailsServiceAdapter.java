package com.sinacolada.tiki.security.user;

import com.sinacolada.tiki.model.entity.User;
import com.sinacolada.tiki.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceAdapter implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User not found: username=%s", username));
        }
        return UserDetailsAdapter.build(user);
    }

}