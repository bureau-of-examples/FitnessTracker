package com.pluralsight.security;

import com.pluralsight.service.UserService;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Objects;

@Component("fitnessTrackerPermissionEvaluator")
public class FitnessTrackerPermissionEvaluator implements PermissionEvaluator {

    @Resource
    private UserService userService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if(targetDomainObject == null)
            return true;

        String username = ((User)authentication.getPrincipal()).getUsername();
        com.pluralsight.model.security.User user = userService.findUser(username);
        if(user == null)
            return false;

        if(Objects.equals(permission, user.getPermissions().get(targetDomainObject.getClass().getName())))
            return true;

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }

}
