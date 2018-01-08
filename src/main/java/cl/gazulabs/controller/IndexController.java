/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gazulabs.controller;

import cl.gazulabs.ejb.UsuarioFacadeLocal;
import cl.gazulabs.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author rodo
 */
@Named
@ViewScoped
public class IndexController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;        
    private Usuario usuario;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String iniciarSesion(){
        Usuario us;
        String redireccion = null;        
        try {
             us = usuarioEJB.iniciarSesion(usuario);
             if (us != null) {
                 //almacenar en la sesion de JSF
                 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                  redireccion = "/protegido/principal?faces-redirect=true";
            }else{
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Credenciales incorrectas"));
             }          
        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al ingresar"));
        }
        return redireccion;
    }
    
    
}
