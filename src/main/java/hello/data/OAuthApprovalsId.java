/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.data;

import java.io.Serializable;

/**
 *
 * @author josorio2
 */
public class OAuthApprovalsId implements Serializable{
    private String userid;
    private String clientid;
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof OAuthApprovalsId){
            OAuthApprovalsId carPk = (OAuthApprovalsId) obj;

            if(!carPk.getUserid().equals(userid)){
                return false;
            }

            if(!carPk.getClientid().equals(clientid)){
                return false;
            }

            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return userid.hashCode() + clientid.hashCode();
    }

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
}
