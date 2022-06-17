package com.casi_td4.DAO;

import java.sql.ResultSet;
import java.util.LinkedList;

import com.casi_td4.modele.BasicEntity;
import com.casi_td4.modele.Compte;
import com.casi_td4.modele.Operation;

public class OperationDAOJson extends DAOJsonGenerique<Operation> {

    private CompteDAOJson daocompte = new CompteDAOJson();

    @Override
    public boolean delete(BasicEntity obj) {
        return false;
    }

    @Override
    public BasicEntity create(BasicEntity obj) {
        Operation op = (Operation) obj;

        Compte compte = (Compte) daocompte.findById(op.getCleCompte());

        if (compte != null) {
            compte.setSolde(compte.getSolde() + op.getMontant());
            compte.addOperation(op);
            daocompte.update(compte);

            return op;
        }

        return null;
    }

    @Override
    public BasicEntity update(BasicEntity obj) {
        return obj;
    }

    @Override
    public BasicEntity findById(int cle) {
        return null;
    }

    @Override
    public BasicEntity findByName(String nom) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LinkedList findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected ResultSet genericFindById(int cle) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected ResultSet genericFindAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected BasicEntity ConvertRowToObj(ResultSet rs) {
        // TODO Auto-generated method stub
        return null;
    }

}
