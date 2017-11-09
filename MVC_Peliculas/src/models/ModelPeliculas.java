/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ninte
 */
public class ModelPeliculas{
    private String id_pelicula;
    private String nombre_pelicula;
    private String formato;
    private String duracion;
    private String descripcion;
    private ModelPrincipal modelPrincipal;
    public ModelPeliculas(ModelPrincipal modelPrincipal){
        this.modelPrincipal = modelPrincipal;
    }
    public void ActualizarPeliculas(){
        modelPrincipal.setSQL_String("Select * From Clientes Order BY ClienteID ASC");
        modelPrincipal.Ejecutar();
        modelPrincipal.primerRegistro();
        AsignarPelicula();
    }
    public void AsignarPelicula(){
        try{
            id_pelicula = modelPrincipal.getSQL_Result_Set().getString("PeliculaID");
            nombre_pelicula = modelPrincipal.getSQL_Result_Set().getString("NombrePelicula");
            formato = modelPrincipal.getSQL_Result_Set().getString("Formato");
            duracion = modelPrincipal.getSQL_Result_Set().getString("Duracion");
            descripcion = modelPrincipal.getSQL_Result_Set().getString("Descripcion");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 105: Pelicula no asignada" + e);
        }
    }
    public void Insertar(){
        try{
            modelPrincipal.setSQL_String("Insert Into Peliculas(Nombre_Peliculas, Formato, Duracion, Descripcion) Values (?,?,?,?);");
            modelPrincipal.PS();
            modelPrincipal.getSQL_Prepared_Statement().setString(1, nombre_pelicula);
            modelPrincipal.getSQL_Prepared_Statement().setString(2, formato);
            modelPrincipal.getSQL_Prepared_Statement().setString(3, duracion);
            modelPrincipal.getSQL_Prepared_Statement().setString(4, descripcion);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 106: Pelicula no insertada" + e);
    }
}
    public void Actualizar(){
        try{
            modelPrincipal.setSQL_String("Update Peliculas Set Nombre_Pelicula = ?, Formato = ?, Duracion = ?, Descripcion = ? Where PeliculaID = ?;");
            modelPrincipal.PS();
            modelPrincipal.getSQL_Prepared_Statement().setInt(1, Integer.parseInt(id_pelicula));
            modelPrincipal.getSQL_Prepared_Statement().setString(2, nombre_pelicula);
            modelPrincipal.getSQL_Prepared_Statement().setString(3, formato);
            modelPrincipal.getSQL_Prepared_Statement().setString(4, duracion);
            modelPrincipal.getSQL_Prepared_Statement().setString(5, descripcion);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 107: Pelicula no Modificada" + e);
    }
}
    public void borrar(){
        try{
            modelPrincipal.setSQL_String("Delete From Peliculas where PeliculaID = ?;");
            modelPrincipal.PS();
            modelPrincipal.getSQL_Prepared_Statement().setInt(1, Integer.parseInt(id_pelicula));
            modelPrincipal.Actualiza();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 108: Cliente no eliminado " + e);
        }
    }
    public String getId_Pelicula(){
        return id_pelicula;
    }
    public void setId_Pelicula(String id_pelicula){
        this.id_pelicula = id_pelicula;
    }
    public String getNombrePelicula(){
        return nombre_pelicula;
    }
    public void setNombrePelicula(String nombre_pelicula){
        this.nombre_pelicula = nombre_pelicula;
    }
    public String getFormato(){
        return formato;
    }
    public void setFormato(String formato){
        this.formato = formato;
    }
    public String getDuracion(){
        return duracion;
    }
    public void setDuracion(String duracion){
        this.duracion = duracion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
