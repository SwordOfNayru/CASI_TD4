package com.casi_td4.Factory;

import com.casi_td4.DAO.CompteDAOJson;
import com.casi_td4.DAO.DAOGenerique;
import com.casi_td4.DAO.OperationDAOJson;
import com.casi_td4.DAO.OperationDAOMySQL;
import com.casi_td4.modele.Compte;
import com.casi_td4.modele.Operation;

public class DAOJsonFactory extends DAOFactory {

    @Override
    public DAOGenerique<Compte> getCompteDAO() {
        return new CompteDAOJson();
    }

    @Override
    public DAOGenerique<Operation> getOperationDAO() {
        return new OperationDAOJson();
    }

}
