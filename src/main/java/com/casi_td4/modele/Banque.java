package com.casi_td4.modele;

import java.util.LinkedList;

public class Banque {
    private LinkedList<Compte> lesComptes;

    public void setLesComptes(LinkedList<Compte> lesComptes) {
        this.lesComptes = lesComptes;
    }

    public LinkedList<Compte> getLesComptes() {
        return lesComptes;
    }

    public Compte addCompte(String numCompte, float solde) {
        Compte newCompte = new Compte(0, numCompte, solde);
        this.lesComptes.add(newCompte);

        return newCompte;
    }
}
