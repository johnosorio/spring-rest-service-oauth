/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.data;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author josorio2
 */
@Entity 
@IdClass(OAuthApprovalsId.class)
@Table(name="\"oauth_approvals\"")
public class OAuthApprovals implements Serializable {
    @Id
    @Column(length = 256)
    private String userid;

    @Id
    @Column(length = 256)
    private String clientid;
    
    @Column(length = 256)
    private String scope;
    
    @Column(length = 10)
    private String status;
            
    private Timestamp expiresat;
    
    private Timestamp lastmodifiedat;
    
    public OAuthApprovals(){}

    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the clientid
     */
    public String getClientid() {
        return clientid;
    }

    /**
     * @param clientid the clientid to set
     */
    public void setClientid(String clientid) {
        this.clientid = clientid;
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the expiresat
     */
    public Timestamp getExpiresat() {
        return expiresat;
    }

    /**
     * @param expiresat the expiresat to set
     */
    public void setExpiresat(Timestamp expiresat) {
        this.expiresat = expiresat;
    }

    /**
     * @return the lastmodifiedat
     */
    public Timestamp getLastmodifiedat() {
        return lastmodifiedat;
    }

    /**
     * @param lastmodifiedat the lastmodifiedat to set
     */
    public void setLastmodifiedat(Timestamp lastmodifiedat) {
        this.lastmodifiedat = lastmodifiedat;
    }
    
    
}
