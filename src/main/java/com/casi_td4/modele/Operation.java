package com.casi_td4.modele;

public class Operation {
    private int cle;
    private String intitule;
    private float montant;
    private String dateOperation;
    private int cleCompte;

    public Operation(int cle, String intitule, float montant, String dateOperation, int cleCompte) {
        this.cle = cle;
        this.intitule = intitule;
        this.montant = montant;
        this.dateOperation = dateOperation;
        this.cleCompte = cleCompte;
    }

    public int getCle() {
        return cle;
    }

    public void setCle(int cle) {
        this.cle = cle;
    }

    public int getCleCompte() {
        return cleCompte;
    }

    public void setCleCompte(int cleCompte) {
        this.cleCompte = cleCompte;
    }

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

}
