package com.casi_td4.modele;

import java.io.Serializable;
import java.util.LinkedList;

public class Compte implements BasicEntity {
    private int cle;
    private String numCompte;
    private float solde;
    private LinkedList<Operation> operations;

    public Compte(int cle, String numCompte, float solde) {
        this.cle = cle;
        this.numCompte = numCompte;
        this.solde = solde;
        this.operations = new LinkedList<Operation>();
    }

    public int getCle() {
        return cle;
    }

    public void setCle(int cle) {
        this.cle = cle;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public LinkedList<Operation> getLesOperations() {
        return operations;
    }

    public void addOperation(String intitule, String date, float montant) {
        this.operations.add(new Operation(0, intitule, montant, date, this.cle));
        this.solde += montant;
        System.out.println("Le solde est de : " + String.valueOf(this.solde));
    }

    public void addOperation(Operation op) {
        this.operations.add(op);
        this.solde += op.getMontant();
    }

    @Override
    public String toString() {
        return this.getNumCompte();
    }
}
