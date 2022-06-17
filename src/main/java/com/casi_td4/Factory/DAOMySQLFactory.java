package com.casi_td4.Factory;

import com.casi_td4.DAO.CompteDAOMySQL;
import com.casi_td4.DAO.DAOGenerique;
import com.casi_td4.DAO.OperationDAOMySQL;
import com.casi_td4.modele.Compte;
import com.casi_td4.modele.Operation;

public class DAOMySQLFactory extends DAOFactory {

    @Override
    public DAOGenerique<Compte> getCompteDAO() {
        return new CompteDAOMySQL();
    }

    @Override
    public DAOGenerique<Operation> getOperationDAO() {
        return new OperationDAOMySQL();
    }

}
