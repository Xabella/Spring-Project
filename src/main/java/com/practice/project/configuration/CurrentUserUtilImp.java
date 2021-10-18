package com.practice.project.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CurrentUserUtilImp implements CurrentUserUtil {

    @Override
    public Authentication getAuthentictionInfor() {

        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public UserDetailsImpl getUserDetails() {

        Authentication authentication = getAuthentictionInfor();

        return (UserDetailsImpl) authentication.getPrincipal();
    }

    @Override
    public long getUserId() {
        UserDetailsImpl userDetailsImpl = getUserDetails();
        return userDetailsImpl.getId();
    }

}
