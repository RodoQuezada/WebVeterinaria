/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gazulabs.controller;

import cl.gazulabs.ejb.MascotaFacadeLocal;
import cl.gazulabs.model.Mascota;
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
public class ListarMascotasController implements Serializable {
    @EJB
    private MascotaFacadeLocal mascotaFacade;
       
    private List<Mascota> listaMascotas;
    
    @PostConstruct
    public void init(){
        listaMascotas = mascotaFacade.findAll();
    }
    
    public String eliminar(Mascota mas){
        try {
            mascotaFacade.remove(mas);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se a eliminador correctamente"));
        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar. Error: "+e));       
        }
        return "listarMascotas";
    }
    
    public List<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(List<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }
    
    
    
    
    
}
