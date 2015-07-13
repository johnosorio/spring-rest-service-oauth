/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.data;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author josorio2
 */
@Entity
@Table(name="\"oauth_refresh_token\"")
public class OAuthRefreshToken implements Serializable {
    @Id
    @Column(length = 256)
    private String token_id;
    private byte[] token;
    private byte[] authentication;
    
    public OAuthRefreshToken(){}

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
    
    
}
