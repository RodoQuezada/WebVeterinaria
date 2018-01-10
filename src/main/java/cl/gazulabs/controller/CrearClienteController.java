/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gazulabs.controller;

import cl.gazulabs.ejb.PersonaFacadeLocal;
import cl.gazulabs.model.Persona;
import java.io.Serializable;
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
public class CrearClienteController implements Serializable{
    @EJB
    private PersonaFacadeLocal personaFacade;
    
    @Inject
    private Persona persona;

    public String registrar(){
        try {
            persona.setCodigo(persona.getRut());
            persona.setCliente(true);
            personaFacade.create(persona);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se a registrado de forma correcta "));
        } catch (Exception e) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar. Error: "+e));       
        }
        return "listarClientes";
    }
    
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
}
