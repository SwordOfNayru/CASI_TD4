package com.casi_td4.modele;

import java.util.LinkedList;

import com.casi_td4.DAO.DAOGenerique;
import com.casi_td4.Factory.DAOFactory;

public class BanqueFacade {

    private Banque banque;
    private DAOFactory factory;

    public BanqueFacade(DAOFactory factory) {
        this.factory = factory;
        banque = new Banque();
        banque.setLesComptes(factory.getCompteDAO().findAll());

        LinkedList<Operation> listOperation = factory.getOperationDAO().findAll();

        if (listOperation != null) {
            for (Operation operation : listOperation) {
                Compte compte = banque.getCompte(operation.getCleCompte());

                if (compte != null) {
                    compte.addOperation(operation);
                }
            }
        }
    }

    public LinkedList<Compte> getLesComptes() {
        return banque.getLesComptes();
    }

    public Compte findCompte(int cle) {
        LinkedList<Compte> lesComptes = banque.getLesComptes();

        for (Compte compte : lesComptes) {
            if (compte.getCle() == cle) {
                return compte;
            }
        }

        return null;
    }

    public Compte ajouterCompte(String num, float solde) {
        Compte compte = factory.getCompteDAO().create(new Compte(0, num, solde));
        return banque.addCompte(compte);
    }

    public Compte enregistrerCompte(int cle) {
        return factory.getCompteDAO().update(banque.getCompte(cle));
    }

    public Compte ajouterOperation(String intitule, String date, float montant, Compte compte) {

        compte.addOperation(new Operation(0, intitule, montant, date, 0));

        return compte;
    }

    public void saveAll() {
        DAOGenerique<Compte> comptedao = factory.getCompteDAO();
        DAOGenerique<Operation> operationdao = factory.getOperationDAO();

        for (Compte compte : banque.getLesComptes()) {
            int cle;

            if (compte.getCle() == 0) {
                comptedao.create(compte);
                cle = compte.getCle();
            } else {
                cle = compte.getCle();
                comptedao.update(compte);
            }

            for (Operation op : compte.getLesOperations()) {
                if (op.getCle() == 0) {
                    op.setCleCompte(cle);
                    operationdao.create(op);
                } else {
                    operationdao.update(op);
                }
            }
        }
    }

}
