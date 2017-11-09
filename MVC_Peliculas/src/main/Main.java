/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import models.*;
import views.*;
import controllers.*;
/**
 *
 * @author ninte
 */
public class Main {
    public static void main (String er[]){
        ModelPrincipal modelPrincipal = new ModelPrincipal();
        ModelPeliculas modelPeliculas = new ModelPeliculas(modelPrincipal);
        ModelCliente modelClientes = new ModelCliente(modelPrincipal);
        
        ViewPrincipal viewPrincipal = new ViewPrincipal();
        ViewCliente viewCliente = new ViewCliente();
        ViewPeliculas viewPeliculas = new ViewPeliculas();
        
        Object[] controllers = new Object[3];
        Object[] models = new Object[3];
        Object[] views = new Object[3];
        
        models[0] = modelPrincipal;
        models[1] = modelClientes;
        models[2] = modelPeliculas;
        
        views[0] = viewPrincipal;
        views[1] = viewCliente;
        views[2] = viewPeliculas;
        
        ControllerClientes controllerCliente = new ControllerClientes(models, views, controllers);
        controllers[1] = controllerCliente;
        ControllerPeliculas controllerPeliculas = new ControllerPeliculas(models, views, controllers);
        controllers[2] = controllerPeliculas;
        ControllerPrincipal controllerPrincipal = new ControllerPrincipal(models, views, controllers);
        controllers[0] = controllerPrincipal;
    }
}
