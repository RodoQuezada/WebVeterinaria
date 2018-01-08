/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gazulabs.controller;

import cl.gazulabs.ejb.UsuarioFacadeLocal;
import cl.gazulabs.model.Persona;
import cl.gazulabs.model.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rodo
 */
@Named
@ViewScoped
public class UsuarioController implements Serializable{
    
    @EJB
    private UsuarioFacadeLocal usuarioEJB;
    
    @Inject
    private Usuario usuario;
    
    @Inject
    private Persona persona;
    
    @PostConstruct
    public void init(){
     //   usuario = new Usuario();
     //   persona = new Persona();                
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public String registrar(){
        try {
            persona.setCodigo(persona.getRut());
            this.usuario.setCodigo(persona);
            usuarioEJB.create(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se a registrado de forma correcta "));
        } catch (Exception e) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar"));
        }
        return "crearEspecie";
    }
    
}
