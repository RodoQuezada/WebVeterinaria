package cl.gazulabs.controller;

import cl.gazulabs.ejb.EspecieFacadeLocal;
import cl.gazulabs.model.Especie;
import java.io.Serializable;
import java.util.List;
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
public class EspecieController implements Serializable {

    @EJB
    private EspecieFacadeLocal especieFacade;

    private Especie especie;
    private List<Especie> lista;

    @PostConstruct
    public void init() {
        especie = new Especie();
        lista = especieFacade.findAll();
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public void create() {
        try {
            if (!especie.getNombre().equals("")) {
                especieFacade.create(especie);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se a registrado de forma correcta "));
            }else{
                System.out.println("error, especie vacio");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Debes ingresar un valor al campo nombre"));
            }            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar"));
        }      
    }

    public void delete(Especie es) {
        System.out.println("eliminar");
        try {
         especieFacade.remove(es);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se a eliminado el registro"));
         } catch (Exception e) {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error al registrar"));
         }      
    }

    public List<Especie> getLista() {
        return lista;
    }

    public void setLista(List<Especie> lista) {
        this.lista = lista;
    }

}
