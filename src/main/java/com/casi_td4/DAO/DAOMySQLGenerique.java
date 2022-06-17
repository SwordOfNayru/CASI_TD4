package com.casi_td4.DAO;

import java.sql.ResultSet;
import java.util.LinkedList;

import com.casi_td4.MySQLManager;
import com.casi_td4.modele.BasicEntity;

public abstract class DAOMySQLGenerique<T extends BasicEntity> extends DAOGenerique<T> {

    protected MySQLManager manager;

    protected String tableName;

    public DAOMySQLGenerique(String tableName) {
        this.manager = MySQLManager.getInstance();
        this.tableName = tableName;
    }

    public boolean delete(T obj) {
        try {
            manager.setData(String.format("DELETE FROM %s WHERE cle = %i;", tableName, obj.getCle()));
            return true;
        } catch (Exception ex) {
            return false;
        }
    };

    public abstract T create(T obj);

    public abstract T update(T obj);

    public void saveAll(LinkedList<T> objs) {
        for (T obj : objs) {
            update(obj);
        }
    }

    public abstract T findById(int cle);

    public abstract T findByName(String nom);

    public abstract LinkedList<T> findAll();

    protected ResultSet genericFindById(int cle) {
        String req = "SELECT * FROM %s WHERE cle = %i;";

        return manager.getData(String.format(req, tableName, cle));
    }

    protected ResultSet genericFindAll() {
        String req = "SELECT * FROM %s;";

        return manager.getData(String.format(req, tableName));
    }

    protected abstract T ConvertRowToObj(ResultSet rs);
}
