package com.casi_td4.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.casi_td4.modele.Compte;

public class CompteDAOMySQL extends DAOMySQLGenerique<Compte> {

    public CompteDAOMySQL() {
        super("compte");
    }

    @Override
    public Compte create(Compte obj) {
        String req = "INSERT INTO compte (num_compte, solde) values ('%s', %s);";
        req = String.format(req, obj.getNumCompte(), String.valueOf(obj.getSolde()));
        obj.setCle(manager.setData(req));
        return obj;
    }

    @Override
    public Compte update(Compte obj) {
        String req = "UPDATE compte SET num_compte = '%s', solde = %s WHERE cle = %s;";
        req = String.format(req, obj.getNumCompte(), String.valueOf(obj.getSolde()), obj.getCle());
        manager.setData(req);
        return obj;
    }

    @Override
    public Compte findById(int cle) {
        ResultSet rs = this.genericFindById(cle);
        try {
            if (!rs.first()) {
                return null;
            }
            return ConvertRowToObj(rs);
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public Compte findByName(String nom) {
        String req = "SELECT * FROM compte WHERE num_compte = '%s';";
        try {
            ResultSet rs = manager.getData(req);
            if (!rs.first()) {
                return null;
            }
            return ConvertRowToObj(rs);
        } catch (SQLException sqlex) {
            return null;
        }
    }

    @Override
    public LinkedList<Compte> findAll() {
        ResultSet rs = this.genericFindAll();
        try {
            LinkedList<Compte> results = new LinkedList<Compte>();
            while (rs.next()) {
                Compte tmp = ConvertRowToObj(rs);
                if (tmp != null) {
                    results.add(tmp);
                }
            }
            return results;
        } catch (SQLException sqlex) {
            return null;
        }

    }

    @Override
    protected Compte ConvertRowToObj(ResultSet rs) {
        try {
            return new Compte(rs.getInt("cle"), rs.getString("num_compte"), rs.getFloat("solde"));
        } catch (SQLException sqlex) {
            return null;
        }

    }

}
