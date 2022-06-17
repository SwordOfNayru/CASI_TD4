package com.casi_td4.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.casi_td4.modele.Operation;

public class OperationDAOMySQL extends DAOMySQLGenerique<Operation> {

    public OperationDAOMySQL() {
        super("operation");
    }

    @Override
    public Operation create(Operation obj) {
        String req = "INSERT INTO operation (intitule, montant, date, id_compte) values ('%s', %s, '%s', %s);";
        req = String.format(req, obj.getIntitule(), String.valueOf(obj.getMontant()), obj.getDateOperation(),
                obj.getCleCompte());
        obj.setCle(manager.setData(req));
        return obj;
    }

    @Override
    public Operation update(Operation obj) {
        String req = "UPDATE Operation SET intitule = '%s', montant = %s, date = '%s', id_compte = %s WHERE cle = %s;";

        manager.setData(String.format(req, obj.getIntitule(), String.valueOf(obj.getMontant()), obj.getDateOperation(),
                obj.getCleCompte(), obj.getCle()));
        return obj;
    }

    @Override
    public Operation findById(int cle) {
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
    public Operation findByName(String nom) {
        String req = "SELECT * FROM Operation WHERE intitule = '%s';";
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
    public LinkedList<Operation> findAll() {
        ResultSet rs = this.genericFindAll();
        try {
            LinkedList<Operation> results = new LinkedList<Operation>();
            while (rs.next()) {
                Operation tmp = ConvertRowToObj(rs);
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
    protected Operation ConvertRowToObj(ResultSet rs) {
        try {
            return new Operation(rs.getInt("cle"), rs.getString("intitule"), rs.getFloat("montant"),
                    rs.getString("date"), rs.getInt("id_compte"));
        } catch (SQLException sqlex) {
            return null;
        }

    }

}
