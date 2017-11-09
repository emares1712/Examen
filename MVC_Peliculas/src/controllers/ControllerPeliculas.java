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
public class ControllerPeliculas {
    private ModelPrincipal modelPrincipal;
    private ModelPeliculas modelPeliculas;
    private ViewPeliculas viewPeliculas;
    public ControllerPeliculas(Object models[], Object views[], Object controllers[]){
        this.modelPrincipal = (ModelPrincipal)models[0];
        this.modelPeliculas = (ModelPeliculas)models[2];
        this.viewPeliculas = (ViewPeliculas)views[2];
        initView();
    }
    public void initView(){
        viewPeliculas.jbtn_primero.addActionListener(e -> jbtn_primer_click());
        viewPeliculas.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
        viewPeliculas.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
        viewPeliculas.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
        viewPeliculas.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
        viewPeliculas.jbtn_editar.addActionListener(e -> jbtn_editar_click());
        viewPeliculas.jbtn_borrar.addActionListener(e -> jbtn_borrar_click());
        viewPeliculas.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
        viewPeliculas.jtf_idPeliculas.setEnabled(false);
    }
    public void getDatos(){
        viewPeliculas.jtf_idPeliculas.setText(modelPeliculas.getId_Pelicula());
        viewPeliculas.jtf_nombre_peliculas.setText(modelPeliculas.getId_Pelicula());
        viewPeliculas.jtf_formato.setText(modelPeliculas.getId_Pelicula());
        viewPeliculas.jtf_duracion.setText(modelPeliculas.getId_Pelicula());
        viewPeliculas.jtf_descripcion.setText(modelPeliculas.getId_Pelicula());
    }
    public void setDatos(){
        modelPeliculas.setId_Pelicula(viewPeliculas.jtf_idPeliculas.getText());
        modelPeliculas.setNombrePelicula(viewPeliculas.jtf_nombre_peliculas.getText());
        modelPeliculas.setFormato("" + viewPeliculas.jtf_formato.getText());
        modelPeliculas.setDuracion(viewPeliculas.jtf_duracion.getText());
        modelPeliculas.setDescripcion(viewPeliculas.jtf_descripcion.getText());
    }
    public void ActualizarFormulario(){
        modelPeliculas.ActualizarPeliculas();
        getDatos();
    }
    public void jbtn_primer_click(){
        modelPrincipal.primerRegistro();
        modelPeliculas.AsignarPelicula();
        getDatos();
    }
    public void jbtn_anterior_click(){
        modelPrincipal.RegistroAnterior();
        modelPeliculas.AsignarPelicula();
        getDatos();
    }
    public void jbtn_siguiente_click(){
        modelPrincipal.RegistroSiguiente();
        modelPeliculas.AsignarPelicula();
        getDatos();
    }
    public void jbtn_ultimo_click(){
        modelPrincipal.UltimoRegistro();
        modelPeliculas.ActualizarPeliculas();
        getDatos();
    }
    public void jbtn_agregar_click(){
        setDatos();
        modelPeliculas.Insertar();
        ActualizarFormulario();
    }
    public void jbtn_editar_click(){
        setDatos();
        modelPeliculas.Actualizar();
        ActualizarFormulario();
    }
    public void jbtn_borrar_click(){
        setDatos();
        modelPeliculas.borrar();
        ActualizarFormulario();
    }
    public void jbtn_nuevo_click(){
        viewPeliculas.jtf_idPeliculas.setText("");
        viewPeliculas.jtf_nombre_peliculas.setText("");
        viewPeliculas.jtf_formato.setText("");
        viewPeliculas.jtf_duracion.setText("");
        viewPeliculas.jtf_descripcion.setText("");
    }
}