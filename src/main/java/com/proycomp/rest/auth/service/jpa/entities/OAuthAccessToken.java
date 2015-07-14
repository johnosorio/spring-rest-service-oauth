/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proycomp.rest.auth.service.jpa.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="oauth_access_token")
public class OAuthAccessToken implements Serializable {
    @Id
    @Column(length = 256)
    private String token_id;
    
    @Lob
    private byte[] token;
    
    @Column(length = 256)
    private String authentication_id;
    
    @Column(length = 256)
    private String user_name;
    
    @Column(length = 256)
    private String client_id;
    
    @Lob
    private byte[] authentication;
    
    @Column(length = 256)
    private String refresh_token;
    
    public OAuthAccessToken() {}

    /**
     * @return the token_id
     */
    public String getToken_id() {
        return token_id;
    }

    /**
     * @param token_id the token_id to set
     */
    public void setToken_id(String token_id) {
        this.token_id = token_id;
    }

    /**
     * @return the token
     */
    public byte[] getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(byte[] token) {
        this.token = token;
    }

    /**
     * @return the authentication_id
     */
    public String getAuthentication_id() {
        return authentication_id;
    }

    /**
     * @param authentication_id the authentication_id to set
     */
    public void setAuthentication_id(String authentication_id) {
        this.authentication_id = authentication_id;
    }

    /**
     * @return the user_name
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the client_id
     */
    public String getClient_id() {
        return client_id;
    }

    /**
     * @param client_id the client_id to set
     */
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    /**
     * @return the authentication
     */
    public byte[] getAuthentication() {
        return authentication;
    }

    /**
     * @param authentication the authentication to set
     */
    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    /**
     * @return the refresh_token
     */
    public String getRefresh_token() {
        return refresh_token;
    }

    /**
     * @param refresh_token the refresh_token to set
     */
    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
    
}
