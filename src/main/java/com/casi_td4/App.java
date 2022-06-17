package com.casi_td4;

import java.util.LinkedList;

import com.casi_td4.DAO.CompteDAOMySQL;
import com.casi_td4.modele.Compte;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        CompteDAOMySQL dao = new CompteDAOMySQL();

        dao.create(new Compte(1, "dddd", 10.5f));

        LinkedList<Compte> comptes = dao.findAll();

        for (Compte compte : comptes) {
            System.out.println(compte.getCle());
        }
    }
}
