package cl.gazulabs.model;

import cl.gazulabs.model.Especie;
import cl.gazulabs.model.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-08T00:47:01")
@StaticMetamodel(Mascota.class)
public class Mascota_ { 

    public static volatile SingularAttribute<Mascota, Especie> especie;
    public static volatile SingularAttribute<Mascota, Integer> codigo;
    public static volatile SingularAttribute<Mascota, Persona> persona;
    public static volatile SingularAttribute<Mascota, Date> fechaNacimiento;
    public static volatile SingularAttribute<Mascota, String> nombre;

}