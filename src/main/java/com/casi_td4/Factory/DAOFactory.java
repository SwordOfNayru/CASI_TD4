package com.casi_td4.Factory;

import java.util.HashMap;

import com.casi_td4.DAO.DAOGenerique;
import com.casi_td4.modele.Compte;
import com.casi_td4.modele.Operation;

public abstract class DAOFactory {

    public DAOFactory() {
    }

    public abstract DAOGenerique<Compte> getCompteDAO();

    public abstract DAOGenerique<Operation> getOperationDAO();

    public static DAOFactory getFactory(Factories enumerator) {
        Class factoryClass = populateHashMap().get(enumerator);

        if (factoryClass == null) {
            return null;
        }

        try {
            return (DAOFactory) factoryClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }

    }

    private static HashMap<Factories, Class> populateHashMap() {
        HashMap<Factories, Class> list = new HashMap<Factories, Class>();

        list.put(Factories.MYSQL, DAOMySQLFactory.class);
        list.put(Factories.JSON, DAOJsonFactory.class);

        return list;
    }

    public enum Factories {
        MYSQL,
        JSON;
    }

}
