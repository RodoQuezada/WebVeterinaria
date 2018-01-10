/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gazulabs.controller;

import cl.gazulabs.ejb.PersonaFacadeLocal;
import cl.gazulabs.model.Persona;
import java.io.Serializable;
import java.util.List;
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
public class ListarClientesController implements Serializable{
    @EJB
    private PersonaFacadeLocal personaFacade;
        
    private List<Persona> listaClientes;

    @PostConstruct
    public void init(){
        listaClientes = personaFacade.buscarClientes();
    }
    
    public String eliminar(Persona per){
        try {
            personaFacade.remove(per);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se a eliminador correctamente"));
        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar. Error: "+e));       
        }
        return "listarClientes";
    }
    
    
    public List<Persona> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Persona> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
    
}
