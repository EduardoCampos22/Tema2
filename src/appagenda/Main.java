/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appagenda;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eduardo
 */

public class Main extends Application 
{
    private EntityManagerFactory emf;
    private EntityManager em;
    
    @Override
    public void start(Stage primaryStage) throws IOException 
    {
        StackPane rootMain = new StackPane(); 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AgendaView.fxml")); 
        Pane rootAgendaView = fxmlLoader.load(); 
        rootMain.getChildren().add(rootAgendaView);
        
        // Conexión a la BD creando los objetos EntityManager y
        // EntityManagerFactory
        emf = Persistence.createEntityManagerFactory("AppAgendaPU");
        em = emf.createEntityManager();
        
        AgendaViewController agendaViewController = (AgendaViewController)fxmlLoader.getController();
        agendaViewController.setEntityManager(em);
        agendaViewController.cargarTodasPersonas();
        
        Scene scene = new Scene(rootMain);
        primaryStage.setTitle("App Agenda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
            launch(args);
    }
    
    @Override
    public void stop() throws Exception 
    {
        em.close();
        emf.close();
        
        try
        {
            DriverManager.getConnection("jdbc:derby:C:\\Users\\Eduardo\\Google Drive\\Modulo\\Desarrollo_de_Interfaces\\Tema_2\\Projectos\\AppAgenda\\BDAgenda;shutdown=true");
        }
        
        catch(SQLException ex) { }
    }
    
}



