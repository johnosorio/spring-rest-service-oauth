/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proycomp.rest.auth.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 *
 * @author josorio2
 */
public class Canon {

    public static void main(String[] args) {
        
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setClientId("curl");
        details.setClientSecret("password");
        details.setGrantType("client_credentials");
        details.setAccessTokenUri("http://localhost:8080/oauth/token");
        
        OAuth2RestTemplate template = new OAuth2RestTemplate(details, new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest()));
        OAuth2AccessToken access = template.getAccessToken();
        System.out.println("ACCESS: " + access);
        System.out.println("ACCESS: " + access.getTokenType());
        System.out.println("ACCESS: " + access.getValue());
        System.out.println("ACCESS: " + access.getAdditionalInformation());
        System.out.println("ACCESS: " + access.getExpiration());
        System.out.println("ACCESS: " + access.getExpiresIn());
        System.out.println("ACCESS: " + access.getRefreshToken());
        System.out.println("ACCESS: " + access.getScope());
        
        ResourceOwnerPasswordResourceDetails details2 = new ResourceOwnerPasswordResourceDetails();
        details2.setUsername("roy");
        details2.setPassword("spring");
        details2.setGrantType("password");
        details2.setClientId("clientapp");
        details2.setClientSecret("123456");
        details2.setAccessTokenUri("http://localhost:8080/oauth/token");
        
        OAuth2RestTemplate template2 = new OAuth2RestTemplate(details2, new DefaultOAuth2ClientContext(new DefaultAccessTokenRequest()));
        OAuth2AccessToken access2 = template2.getAccessToken();
        System.out.println("ACCESS2: " + access2);
        System.out.println("ACCESS2: " + access2.getTokenType());
        System.out.println("ACCESS2: " + access2.getValue());
        System.out.println("ACCESS2: " + access2.getAdditionalInformation());
        System.out.println("ACCESS2: " + access2.getExpiration());
        System.out.println("ACCESS2: " + access2.getExpiresIn());
        System.out.println("ACCESS2: " + access2.getRefreshToken());
        System.out.println("ACCESS2: " + access2.getScope());
    }
}
