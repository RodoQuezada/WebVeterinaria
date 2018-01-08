/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gazulabs.ejb;

import cl.gazulabs.model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rodo
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {
    @PersistenceContext(unitName = "veterinariaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    @Override
    public List<Persona> buscarClientes(){
        List<Persona> lista = new ArrayList<>();
        String consulta;
        try {
            consulta = "FROM Persona p WHERE p.cliente=?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, true);           
            lista = query.getResultList();
           
        } catch (Exception e) {
            throw e;
        } 
        return lista;        
    }
    
}
