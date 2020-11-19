/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appagenda;

/**
 *
 * @author Eduardo
 */

import entidades.Provincia;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppAgenda 
{

    public static void main(String[] args) 
    {        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppAgendaPU");
        EntityManager em = emf.createEntityManager();

        
        Provincia provinciaCadiz = new Provincia();
        provinciaCadiz.setNombre("Cadiz");
        em.getTransaction().begin();
        em.persist(provinciaCadiz);
        em.getTransaction().commit();
        
        Provincia provinciaSevilla=new Provincia();
        provinciaSevilla.setNombre("Sevilla");
        em.getTransaction().begin();
        em.persist(provinciaSevilla);
        em.getTransaction().commit();
        
        
        em.close();
        emf.close();
        
        try 
        {
        DriverManager.getConnection("jdbc:derby:C:\\Users\\Eduardo\\Google Drive\\Modulo\\Desarrollo_de_Interfaces\\Tema_2\\Projectos\\AppAgenda\\BDAgenda;shutdown=true");
        } 
        
        catch (SQLException ex) { }
    }
}
