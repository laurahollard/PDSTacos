/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv.DB;

import main.java.serv.model.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.and;
import static javax.management.Query.and;


/**
 * Class which represent a implementation of VehiculeDAO
 * @author hammadin hollardl
 */
public class UserDAOImpl implements UserDAO {
    /* Implémentation de la méthode trouver() définie dans l'interface UtilisateurDao */
	/**
	 * Instance of DAOFactory
	 */
    private final ConnectionPool connectionPool;
    
    /**
     * Instance of Connection to the database
     */
    private Connection connection;
    private Statement ordre;
    /**
     * Class contructor
     * @param daoFactory an instance of DAOFactory
     */
    public UserDAOImpl(ConnectionPool connect) {
        this.connectionPool = connect;
        this.connection = connectionPool.getConnectionPool();
    }
    
    /**
     * Find a vehicle into the database
     * @param id The vehicle's id
     */
    public User find( int id ) throws DAOException {
        
        User u = null;
        try {
             ordre = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "select * from employees where id = "+id;
      
        try {
           ResultSet rs = ordre.executeQuery(sql);
           while(rs.next()){
            int identifiant = rs.getInt(1);
            String pswd = rs.getString(2) ;
            String last_name = rs.getString(3);
            String first_name = rs.getString(4);
            String email =  rs.getString(5);
            Boolean is_manager = rs.getBoolean(6);
            u = new User(identifiant,pswd,last_name,first_name,email,is_manager);
           }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            ordre.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
        
    }
    
    
    /**
     * Insert a vehicle into the database
     * @param id The vehicle's id
     */
    public void insert(User u) throws DAOException {
        int id = u.getId_employee();
        String pswd = u.getPassword();
        String last_name = u.getLast_name();
        String first_name = u.getFirst_name();
        String mail = u.getEmail();
        Boolean manager = u.getIs_manager();
        
        
        
        try {
             ordre = connection.createStatement();
             
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       String sql = "INSERT INTO employees  VALUES("+id+","+pswd+","+last_name+","+first_name+","+mail+","+manager+")";
       
        try {
            ordre.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ordre.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    /**
     * Update a vehicle into the database
     * @param id The vehicle's id
     */
    public void update(User u) throws DAOException {
        
        int id = u.getId_employee();
        String pswd = u.getPassword();
        String last_name = u.getLast_name();
        String first_name = u.getFirst_name();
        String mail = u.getEmail();
        Boolean manager = u.getIs_manager();
        
         try {
             ordre = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "UPDATE employees SET  pass_word ="+pswd+" where id = "+id; 
      
        try {
            ordre.executeUpdate(sql);
          
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ordre.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    /**
     * Delete a vehicle from the database
     * @param id The vehicle's id
     */
    public void delete(int id) throws DAOException {
        
        
        try {
             ordre = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "DELETE from employees where id = "+id;
      
        try {
            ordre.executeUpdate(sql);
          
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ordre.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Boolean checkUserdb(String username, String password){
        String u_name =null ;
        String pswd = null;
        Boolean bool = null;
        
        try {
             ordre = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "select email,pass_word from employees where email = "+username;
      
        try {
           ResultSet rs = ordre.executeQuery(sql);
           while(rs.next()){
               u_name = rs.getString(1);
               pswd = rs.getString(2);
           }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            ordre.close();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculeDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(u_name == username && pswd == password){
            bool = true;
        }
        else{
            bool = false;
        }
        return bool;
    }
}

