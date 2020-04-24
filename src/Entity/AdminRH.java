package Entity;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class AdminRH{
    private String login;
    private String mdp;
    private int etat_compte;
    private String mail;

    public AdminRH() {
        this.login="";
    }

    public AdminRH(String login, String mdp, String mail) {
        this.login = login;
        this.mdp = mdp;
        this.mail = mail;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.login);
        hash = 79 * hash + Objects.hashCode(this.mdp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AdminRH other = (AdminRH) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.mdp, other.mdp)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AdminRH{" + "login=" + login + ", mdp=" + mdp + ", etat_compte=" + etat_compte + ", mail=" + mail + '}';
    }

    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the mdp
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * @param mdp the mdp to set
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * @return the etat_compte
     */
    public int getEtat_compte() {
        return etat_compte;
    }

    /**
     * @param etat_compte the etat_compte to set
     */
    public void setEtat_compte(int etat_compte) {
        this.etat_compte = etat_compte;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
}
