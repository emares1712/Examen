/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author ninte
 */
public class ModelPrincipal {
    private Connection sql_connection;
    private Statement sql_statement;
    private PreparedStatement sql_prepared_statement;
    private ResultSet sql_result_set;
    private String sql;
    public void Conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            sql_connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Cine", "postgres", "");
            sql_statement = sql_connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch(ClassNotFoundException f){
            JOptionPane.showMessageDialog(null,":(");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 109: Error de conexion " + e);
        }
    }
         public void Ejecutar(){
        try{
            Conectar();
            sql_result_set = sql_statement.executeQuery(sql);
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 110: Error al ejecutar " +  e);
        }
    }
    
    public void Actualiza(){
        try{
            sql_prepared_statement.executeUpdate();
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 111: Error al ejecutar actualizacion " + e);
        }
    }
    
    public void PS(){
        try{
            Conectar();
            sql_prepared_statement = sql_connection.prepareStatement(sql);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 112: Error al ejecutar Prepared Satatement " + e);
        }
    }
    
    public void primerRegistro(){
        try{
            if(sql_result_set.isFirst() == false){
                sql_result_set.first();
            }
            else{
                //
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 113: Eoor al mover al primer registro" + e);
        }
    }
    
    public void RegistroAnterior(){
        try{
            if(sql_result_set.isFirst() == false){
                sql_result_set.previous();
            }
            else{
                //
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 114: Error al ir al registro anterior " + e);
        }
    }
    
    public void RegistroSiguiente(){
        try{
            if(sql_result_set.isLast() == false){
                sql_result_set.next();
            }
            else{
                //
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 115: Error al ir al siguiente registro " + e);
        }
    }
    
    public void UltimoRegistro(){
        try{
            if(sql_result_set.isLast() == false){
                sql_result_set.last();
            }
            else{
                //
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 116: Error al ir al ultimo registro " + e);
        }
    }
    
    public Connection getSQL_Connector(){
        return sql_connection;
    }
    
    public PreparedStatement getSQL_Prepared_Statement(){
        return sql_prepared_statement;
    }
    
    public ResultSet getSQL_Result_Set(){
        return sql_result_set;
    }
    
    public String getSQL_String(){
        return sql;
    }
    
    public void setSQL_String(String sql){
        this.sql = sql;
    }
    
}
