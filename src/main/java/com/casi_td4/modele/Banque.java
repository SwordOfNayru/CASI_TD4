package com.casi_td4.modele;

import java.io.Serializable;
import java.util.LinkedList;

public class Banque implements Serializable {

    private LinkedList<Compte> lesComptes;

    public Banque() {
        lesComptes = new LinkedList<Compte>();
    }

    public void setLesComptes(LinkedList<Compte> lesComptes) {
        this.lesComptes = lesComptes;
    }

    public LinkedList<Compte> getLesComptes() {
        return lesComptes;
    }

    public Compte getCompte(int cle) {
        for (Compte compte : lesComptes) {
            if (compte.getCle() == cle) {
                return compte;
            }
        }

        return null;
    }

    public Compte addCompte(String numCompte, float solde) {
        Compte newCompte = new Compte(0, numCompte, solde);
        this.lesComptes.add(newCompte);

        return newCompte;
    }

    public Compte addCompte(Compte compte) {
        this.lesComptes.add(compte);
        return compte;
    }
}
