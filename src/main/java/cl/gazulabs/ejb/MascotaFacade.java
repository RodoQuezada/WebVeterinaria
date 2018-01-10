/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.gazulabs.ejb;

import cl.gazulabs.model.Mascota;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rodo
 */
@Stateless
public class MascotaFacade extends AbstractFacade<Mascota> implements MascotaFacadeLocal {
    @PersistenceContext(unitName = "veterinariaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MascotaFacade() {
        super(Mascota.class);
    }
    
}
