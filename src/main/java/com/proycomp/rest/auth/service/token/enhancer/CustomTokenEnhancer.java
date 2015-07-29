/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proycomp.rest.auth.service.token.enhancer;

import com.proycomp.rest.auth.service.jpa.entities.Role;
import com.proycomp.rest.auth.service.jpa.entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

/**
 * Class that allow us to return aditional information into the token.
 * 
 * @author John Jairo Osorio Carmona.
 */
public class CustomTokenEnhancer implements TokenEnhancer {

    /**
     * Method that enchance the token created.
     * @param accessToken - access token generated.
     * @param authentication - authentication information.
     * @return 
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        
        // Enhance for users with username and password
        if (authentication.getPrincipal() instanceof User) {
            User user = (User) authentication.getPrincipal();
            final Map<String, Object> additionalInfo = new HashMap<>();

            List<String> roles = new ArrayList<>();
            for (Role rol : user.getRoles()) {
                roles.add(rol.getName());
            }
            
            additionalInfo.put("authorities", roles);

            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        } 
        
        // Enhance for users with access key and secret key
        if (authentication.getPrincipal() instanceof String) {
            final Map<String, Object> additionalInfo = new HashMap<>();
                    
            List<String> roles = new ArrayList<>();
            for (GrantedAuthority authority : authentication.getAuthorities() ) {
                roles.add(authority.getAuthority());
            }

            additionalInfo.put("authorities", roles);

            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        }

        return accessToken;
    }

}
