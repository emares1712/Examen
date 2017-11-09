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
public class ControllerPrincipal {
    private ModelPeliculas modelPeliculas;
    private ModelCliente modelClientes;
    private ViewPrincipal viewPrincipal;
    private ViewPeliculas viewPeliculas;
    private ViewCliente viewClientes;
    private ControllerClientes controllerClientes;
    private ControllerPeliculas controllerPeliculas;
    
    public ControllerPrincipal(Object models[], Object views[], Object controllers[]){
        this.modelPeliculas = (ModelPeliculas)models[2];
        this.modelClientes = (ModelCliente)models[1];
        this.viewPrincipal = (ViewPrincipal)views[0];
        this.viewPeliculas = (ViewPeliculas)views[2];
        this.viewClientes = (ViewCliente)views[1];
        this.controllerClientes = (ControllerClientes)controllers[1];
        this.controllerPeliculas = (ControllerPeliculas)controllers[2];
        initView();
    }
    
    public void initView(){
        viewPrincipal.setTitle("Blockbuster");
        viewPrincipal.setLocationRelativeTo(null);
        viewPrincipal.setVisible(true);
        viewPrincipal.jmi_pelicula.addActionListener(e ->jmi_peliculas_click());
        viewPrincipal.jmi_cliente.addActionListener(e -> jmi_clientes_click());
    }
    
    public void jmi_peliculas_click(){
        viewPrincipal.setContentPane(viewPeliculas);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
        controllerPeliculas.ActualizarFormulario();
    }
    
    public void jmi_clientes_click(){
        viewPrincipal.setContentPane(viewClientes);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
        controllerClientes.ActualizarFormulario();
    }
}