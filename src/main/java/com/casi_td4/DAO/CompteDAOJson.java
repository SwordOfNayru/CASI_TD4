package com.casi_td4.DAO;

import java.sql.ResultSet;
import java.util.LinkedList;

import com.casi_td4.JsonManager;
import com.casi_td4.Factory.DAOJsonFactory;
import com.casi_td4.modele.Banque;
import com.casi_td4.modele.BasicEntity;
import com.casi_td4.modele.Compte;

public class CompteDAOJson extends DAOJsonGenerique<Compte> {

    private Banque banque;
    private String path = "banque.json";

    public CompteDAOJson() {
        openBanque();
    }

    @Override
    public boolean delete(BasicEntity obj) {
        LinkedList<Compte> lesCompte = banque.getLesComptes();
        for (Compte compte : lesCompte) {
            if (compte.getCle() == obj.getCle()) {
                lesCompte.remove(compte);
                saveBanque();
                return true;
            }
        }
        return false;
    }

    @Override
    public BasicEntity create(BasicEntity obj) {
        int cle = banque.getLesComptes().size() + 1;
        obj.setCle(cle);
        banque.addCompte((Compte) obj);
        saveBanque();
        return obj;
    }

    @Override
    public BasicEntity update(BasicEntity obj) {
        LinkedList<Compte> LesComptes = banque.getLesComptes();
        for (int i = LesComptes.size() - 1; i > -1; i--) {
            if (LesComptes.get(i).getCle() == obj.getCle()) {
                LesComptes.remove(i);
                LesComptes.add((Compte) obj);
            }
        }
        banque.setLesComptes(LesComptes);
        saveBanque();
        return obj;
    }

    @Override
    public BasicEntity findById(int cle) {
        return banque.getCompte(cle);
    }

    @Override
    public BasicEntity findByName(String nom) {
        return null;
    }

    @Override
    public LinkedList findAll() {
        return banque.getLesComptes();
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

    private void saveBanque() {
        JsonManager.getInstance().SaveBanque(banque, path);

    }

    private void openBanque() {
        if (banque == null) {
            banque = JsonManager.getInstance().ReadObject(path);
            if (banque == null) {
                banque = new Banque();
            }
        }
    }

}
