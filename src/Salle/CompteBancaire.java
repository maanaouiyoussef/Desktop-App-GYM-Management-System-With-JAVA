package Salle;


import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maanaoui
 */
public class CompteBancaire {
    private String nomPrenom; 
    private float balance; 
    private String PIN; 
    private String CIN; 
    
    
    // public: to access the constructor outside the package !!!!
    public CompteBancaire(String CIN,String nomPrenom,float Balance,String PIN) {
        this.nomPrenom = nomPrenom; 
        this.balance = Balance; 
        this.PIN = PIN; 
        this.CIN = CIN; 
    }
    
    public void deposit(float amount) {
        if(amount>0) {
            this.balance+=amount; 
        }
    }
    
    public boolean tirer(float amount) {
        if(this.balance>amount) {
            this.balance-=amount; 
            return true;
        } else {
            JOptionPane.showConfirmDialog(null, "Error: Solde Insuffisant !","Solde Error",JOptionPane.CLOSED_OPTION); 
            return false;
        } 
    }
    
    public float getBalance() {
        return balance; 
    }
    
    public String getCIN() {
        return CIN;
    }
    
    public String getPIN() {
        return PIN; 
    }
    
    public String getNomPrenom() {
        return nomPrenom;
    }
    
    public void setPin(String newPin) {
        this.PIN = newPin; 
    }
    
}
