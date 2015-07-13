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
@Table(name="\"oauth_client_token\"")
public class OAuthClientToken implements Serializable {
    @Id
    @Column(length = 256)
    private String token_id;
    private byte[] token;
    @Column(length = 256)
    private String authentication_id;
    @Column(length = 256)
    private String user_name;
    @Column(length = 256)
    private String client_id;
    
    public OAuthClientToken() {}

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
    
    
}
