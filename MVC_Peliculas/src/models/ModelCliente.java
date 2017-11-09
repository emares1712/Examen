/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ninte
 */
public class ModelCliente {
    private String id_cliente;
    private String nombre_cliente;
    private String telefono;
    private String correo;
    private String direccion;
    private ModelPrincipal modelPrincipal;
    public ModelCliente(ModelPrincipal modelPrincipal){
        this.modelPrincipal = modelPrincipal;
    }
    public void ActualizarCliente(){
        modelPrincipal.setSQL_String("Select * From Clientes Order BY ClienteID ASC");
        modelPrincipal.Ejecutar();
        modelPrincipal.primerRegistro();
        AsignarCliente();
    }
    public void AsignarCliente(){
        try{
            id_cliente = modelPrincipal.getSQL_Result_Set().getString("ClienteID");
            nombre_cliente = modelPrincipal.getSQL_Result_Set().getString("NombreCliente");
            telefono = modelPrincipal.getSQL_Result_Set().getString("Telefono");
            correo = modelPrincipal.getSQL_Result_Set().getString("Correo");
            direccion = modelPrincipal.getSQL_Result_Set().getString("Direccion");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 101: Cliente no asignado" + e);
        }
    }
    public void Insertar(){
        try{
            modelPrincipal.setSQL_String("Insert Into Clientes(Nombre_Cliente, Telefono, Correo, Direccion) Values (?,?,?,?);");
            modelPrincipal.PS();
            modelPrincipal.getSQL_Prepared_Statement().setString(1, nombre_cliente);
            modelPrincipal.getSQL_Prepared_Statement().setString(2, telefono);
            modelPrincipal.getSQL_Prepared_Statement().setString(3, correo);
            modelPrincipal.getSQL_Prepared_Statement().setString(4, direccion);
            modelPrincipal.Actualiza();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 102: Cliente no insertado" + e);
    }
}
    public void Actualizar(){
        try{
            modelPrincipal.setSQL_String("Insert Into Clientes(Nombre_Cliente, Telefono, Correo, Direccion) Values (?,?,?,?);");
            modelPrincipal.PS();
            modelPrincipal.getSQL_Prepared_Statement().setInt(1, Integer.parseInt(id_cliente));
            modelPrincipal.getSQL_Prepared_Statement().setString(2, nombre_cliente);
            modelPrincipal.getSQL_Prepared_Statement().setString(3, telefono);
            modelPrincipal.getSQL_Prepared_Statement().setString(4, correo);
            modelPrincipal.getSQL_Prepared_Statement().setString(5, direccion);
            modelPrincipal.Actualiza();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 103: Cliente no modificado" + e);
    }
}
    public void borrar(){
        try{
            modelPrincipal.setSQL_String("Delete From Clientes where ClienteID = ?;");
            modelPrincipal.PS();
            modelPrincipal.getSQL_Prepared_Statement().setInt(1, Integer.parseInt(id_cliente));
            modelPrincipal.Actualiza();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 104: Cliente no eliminado: " + e);
        }
    }
    public String getClienteId(){
        return id_cliente;
    }
    public void setClienteId(String id_cliente){
        this.id_cliente = id_cliente;
    }
    public String getNombre(){
        return nombre_cliente;
    }
    public void setNombre(String nombre_cliente){
        this.nombre_cliente = nombre_cliente;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
}
