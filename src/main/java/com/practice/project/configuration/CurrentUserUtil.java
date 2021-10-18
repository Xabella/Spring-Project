package com.practice.project.configuration;

import org.springframework.security.core.Authentication;
import java.util.UUID;

public interface CurrentUserUtil {

    Authentication getAuthentictionInfor();

    UserDetailsImpl getUserDetails();

    long getUserId();

}