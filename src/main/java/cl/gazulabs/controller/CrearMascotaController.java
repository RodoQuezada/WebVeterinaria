/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gazulabs.controller;

import cl.gazulabs.ejb.EspecieFacadeLocal;
import cl.gazulabs.ejb.MascotaFacadeLocal;
import cl.gazulabs.ejb.PersonaFacadeLocal;
import cl.gazulabs.model.Especie;
import cl.gazulabs.model.Mascota;
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
public class CrearMascotaController implements Serializable {

    @EJB
    private PersonaFacadeLocal personaFacade;

    @EJB
    private EspecieFacadeLocal especieFacade;

    @EJB
    private MascotaFacadeLocal mascotaFacade;

    private List<Persona> listaPersona;

    private List<Especie> listaEspecies;

    private Mascota mascota;
    private Persona persona;
    private Especie especie;
    
    @PostConstruct
    public void init() {
        especie = new Especie();
        persona = new Persona();
        mascota = new Mascota();
        listaPersona = personaFacade.buscarClientes();
        listaEspecies = especieFacade.findAll();
    }

    public String crear(){
        try {
            mascota.setPersona(persona);
            mascota.setEspecie(especie);
            mascotaFacade.create(mascota);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se a creado correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar. Error: "+e)); 
        }
        return "listarMascotas";
    }
    
    
    public EspecieFacadeLocal getEspecieFacade() {
        return especieFacade;
    }

    public void setEspecieFacade(EspecieFacadeLocal especieFacade) {
        this.especieFacade = especieFacade;
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public List<Especie> getListaEspecies() {
        return listaEspecies;
    }

    public void setListaEspecies(List<Especie> listaEspecies) {
        this.listaEspecies = listaEspecies;
    }   

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

}
