/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proycomp.rest.auth.service;

import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 * Authorization server test from Java.
 * 
 * @author John Jairo Osorio Carmona
 */
public class Canon {

    public static void main(String[] args) {
        
        ClientCredentialsResourceDetails clientCredentialsRequest1 = new ClientCredentialsResourceDetails();
        clientCredentialsRequest1.setClientId("curl");
        clientCredentialsRequest1.setClientSecret("password");
        clientCredentialsRequest1.setGrantType("client_credentials");
        clientCredentialsRequest1.setAccessTokenUri("http://localhost:8080/oauth/token");
        
        OAuth2RestTemplate templateForClienteCredentials1 = new OAuth2RestTemplate(clientCredentialsRequest1, new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest()));
        OAuth2AccessToken accessToken1 = templateForClienteCredentials1.getAccessToken();
        System.out.println("**************************************************************************************");
        System.out.println("Request Details::: AccessKey: curl, SecretKey: password:, GrantType: cliente_credentials ");
        System.out.println("**************************************************************************************");
        System.out.println("Token Type: " + accessToken1.getTokenType());
        System.out.println("Value: " + accessToken1.getValue());
        System.out.println("Aditional Information: " + accessToken1.getAdditionalInformation());
        System.out.println("Expiration: " + accessToken1.getExpiration());
        System.out.println("Expires In: " + accessToken1.getExpiresIn());
        System.out.println("Refresh Token: " + accessToken1.getRefreshToken());
        System.out.println("Scope: " + accessToken1.getScope());
        System.out.println("**************************************************************************************");
                
        ResourceOwnerPasswordResourceDetails clientResourceOwnerPassword = new ResourceOwnerPasswordResourceDetails();
        clientResourceOwnerPassword.setUsername("roy"); // Username
        clientResourceOwnerPassword.setPassword("spring"); // Password
        clientResourceOwnerPassword.setGrantType("password"); 
        clientResourceOwnerPassword.setClientId("clientapp"); // App AccessKey
        clientResourceOwnerPassword.setClientSecret("123456"); // App SecretKey
        clientResourceOwnerPassword.setAccessTokenUri("http://localhost:8080/oauth/token");
        
        OAuth2RestTemplate templateForResourceOwnerPassword = new OAuth2RestTemplate(clientResourceOwnerPassword, new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest()));
        OAuth2AccessToken accessToken3 = templateForResourceOwnerPassword.getAccessToken();
        System.out.println("**************************************************************************************");
        System.out.println("Request Details::: User: roy, Password: spring:, GrantType: password, AccessKey:clientapp, SecretKey:123456");
        System.out.println("**************************************************************************************");
        System.out.println("Token Type: " + accessToken3.getTokenType());
        System.out.println("Value: " + accessToken3.getValue());
        System.out.println("Aditional Information: " + accessToken3.getAdditionalInformation());
        System.out.println("Expiration: " + accessToken3.getExpiration());
        System.out.println("Expires In: " + accessToken3.getExpiresIn());
        System.out.println("Refresh Token: " + accessToken3.getRefreshToken());
        System.out.println("Scope: " + accessToken3.getScope());
        System.out.println("**************************************************************************************");
        
        ClientCredentialsResourceDetails clientCredentialsRequest2 = new ClientCredentialsResourceDetails();
        clientCredentialsRequest2.setClientId("oauth-admin");
        clientCredentialsRequest2.setClientSecret("oauth-admin-service-secret-key");
        clientCredentialsRequest2.setGrantType("client_credentials");
        clientCredentialsRequest2.setAccessTokenUri("http://localhost:8080/oauth/token");
        
        OAuth2RestTemplate templateForClienteCredentials2 = new OAuth2RestTemplate(clientCredentialsRequest2, new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest()));
        OAuth2AccessToken accessToken2 = templateForClienteCredentials2.getAccessToken();
        System.out.println("**************************************************************************************");
        System.out.println("Request Details::: AccessKey: oauth-admin, SecretKey: admin:, GrantType: cliente_credentials ");
        System.out.println("**************************************************************************************");
        System.out.println("Token Type: " + accessToken2.getTokenType());
        System.out.println("Value: " + accessToken2.getValue());
        System.out.println("Aditional Information: " + accessToken2.getAdditionalInformation());
        System.out.println("Expiration: " + accessToken2.getExpiration());
        System.out.println("Expires In: " + accessToken2.getExpiresIn());
        System.out.println("Refresh Token: " + accessToken2.getRefreshToken());
        System.out.println("Scope: " + accessToken2.getScope());
        System.out.println("**************************************************************************************");
    }
}