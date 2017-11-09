/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.*;
import views.*;
/**
 *
 * @author ninte
 */
public class ControllerClientes {
    private ModelPrincipal modelPrincipal;
    private ModelCliente modelClientes;
    private ViewCliente viewClientes;
    public ControllerClientes(Object models[], Object views[], Object controllers[]){
        this.modelPrincipal = (ModelPrincipal)models[0];
        this.modelClientes = (ModelCliente)models[1];
        this.viewClientes = (ViewCliente)views[1];
        initView();
    }
    public void initView(){
        viewClientes.jbtn_primero.addActionListener(e -> jbtn_primer_click());
        viewClientes.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
        viewClientes.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
        viewClientes.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
        viewClientes.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
        viewClientes.jbtn_editar.addActionListener(e -> jbtn_editar_click());
        viewClientes.jbtn_borrar.addActionListener(e -> jbtn_borrar_click());
        viewClientes.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
        viewClientes.jtf_idCliente.setEnabled(false);
    }
    public void getDatos(){
        viewClientes.jtf_idCliente.setText(modelClientes.getClienteId());
        viewClientes.jtf_nombre_cliente.setText(modelClientes.getNombre());
        viewClientes.jtf_telefono.setText(modelClientes.getTelefono());
        viewClientes.jtf_correo.setText(modelClientes.getCorreo());
        viewClientes.jtf_direccion.setText(modelClientes.getDireccion());
    }
    public void setDatos(){
        modelClientes.setClienteId(viewClientes.jtf_idCliente.getText());
        modelClientes.setNombre(viewClientes.jtf_nombre_cliente.getText());
        modelClientes.setTelefono("" + viewClientes.jtf_telefono.getText());
        modelClientes.setCorreo(viewClientes.jtf_correo.getText());
        modelClientes.setDireccion(viewClientes.jtf_direccion.getText());
    }
    public void ActualizarFormulario(){
        modelClientes.ActualizarCliente();
        getDatos();
    }
    public void jbtn_primer_click(){
        modelPrincipal.primerRegistro();
        modelClientes.AsignarCliente();
        getDatos();
    }
    public void jbtn_anterior_click(){
        modelPrincipal.RegistroAnterior();
        modelClientes.AsignarCliente();
        getDatos();
    }
    public void jbtn_siguiente_click(){
        modelPrincipal.RegistroSiguiente();
        modelClientes.AsignarCliente();
        getDatos();
    }
    public void jbtn_ultimo_click(){
        modelPrincipal.UltimoRegistro();
        modelClientes.ActualizarCliente();
        getDatos();
    }
    public void jbtn_agregar_click(){
        setDatos();
        modelClientes.Insertar();
        ActualizarFormulario();
    }
    public void jbtn_editar_click(){
        setDatos();
        modelClientes.Actualizar();
        ActualizarFormulario();
    }
    public void jbtn_borrar_click(){
        setDatos();
        modelClientes.borrar();
        ActualizarFormulario();
    }
    public void jbtn_nuevo_click(){
        viewClientes.jtf_idCliente.setText("");
        viewClientes.jtf_nombre_cliente.setText("");
        viewClientes.jtf_telefono.setText("");
        viewClientes.jtf_correo.setText("");
        viewClientes.jtf_direccion.setText("");
    }
}
