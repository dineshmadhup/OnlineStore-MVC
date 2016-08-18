
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dinesh
 */
public class DatabaseConnection {

    private Connection conn;// = null;
    public DatabaseConnection() {
        conn = null;
    }
    
    public Connection connect(){        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cs532_finalproject","root", "");
            
        }catch(ClassNotFoundException e){
        } catch (SQLException e) {
        }
        return conn;
    }
    
    public ResultSet query(PreparedStatement stmt){
        ResultSet  rs = null;
        try {
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public void close(){
        try {
            if (conn != null) 
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int update(PreparedStatement stmt) {
        int row = 0;
        try {
            row = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row;
    }
    
    
}
