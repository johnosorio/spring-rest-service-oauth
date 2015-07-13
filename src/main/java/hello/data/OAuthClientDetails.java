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
@Table(name="\"oauth_client_details\"")
public class OAuthClientDetails implements Serializable {
    @Id
    @Column(length = 256, nullable = false)
    private String client_id;
    @Column(length = 256)
    private String resource_ids;
    @Column(length = 256)
    private String client_secret;
    @Column(length = 256)
    private String scope;
    @Column(length = 256)
    private String authorized_grant_types;
    @Column(length = 256)
    private String web_server_redirect_uri;
    @Column(length = 256)
    private String authorities;
    
    private Integer access_token_validity;
            
    private Integer refresh_token_validity;
    @Column(length = 4096)
    private String additional_information;
    @Column(length = 256)
    private String autoapprove;

    public OAuthClientDetails() {}

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
     * @return the resource_ids
     */
    public String getResource_ids() {
        return resource_ids;
    }

    /**
     * @param resource_ids the resource_ids to set
     */
    public void setResource_ids(String resource_ids) {
        this.resource_ids = resource_ids;
    }

    /**
     * @return the client_secret
     */
    public String getClient_secret() {
        return client_secret;
    }

    /**
     * @param client_secret the client_secret to set
     */
    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    /**
     * @return the scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * @return the authorized_grant_types
     */
    public String getAuthorized_grant_types() {
        return authorized_grant_types;
    }

    /**
     * @param authorized_grant_types the authorized_grant_types to set
     */
    public void setAuthorized_grant_types(String authorized_grant_types) {
        this.authorized_grant_types = authorized_grant_types;
    }

    /**
     * @return the web_server_redirect_uri
     */
    public String getWeb_server_redirect_uri() {
        return web_server_redirect_uri;
    }

    /**
     * @param web_server_redirect_uri the web_server_redirect_uri to set
     */
    public void setWeb_server_redirect_uri(String web_server_redirect_uri) {
        this.web_server_redirect_uri = web_server_redirect_uri;
    }

    /**
     * @return the authorities
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * @param authorities the authorities to set
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    /**
     * @return the access_token_validity
     */
    public Integer getAccess_token_validity() {
        return access_token_validity;
    }

    /**
     * @param access_token_validity the access_token_validity to set
     */
    public void setAccess_token_validity(Integer access_token_validity) {
        this.access_token_validity = access_token_validity;
    }

    /**
     * @return the refresh_token_validity
     */
    public Integer getRefresh_token_validity() {
        return refresh_token_validity;
    }

    /**
     * @param refresh_token_validity the refresh_token_validity to set
     */
    public void setRefresh_token_validity(Integer refresh_token_validity) {
        this.refresh_token_validity = refresh_token_validity;
    }

    /**
     * @return the additional_information
     */
    public String getAdditional_information() {
        return additional_information;
    }

    /**
     * @param additional_information the additional_information to set
     */
    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }

    /**
     * @return the autoapprove
     */
    public String getAutoapprove() {
        return autoapprove;
    }

    /**
     * @param autoapprove the autoapprove to set
     */
    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }
    
    
}
