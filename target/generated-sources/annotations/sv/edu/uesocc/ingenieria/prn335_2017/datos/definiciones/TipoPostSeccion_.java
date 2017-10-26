package sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPostSeccionPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-25T17:41:59")
@StaticMetamodel(TipoPostSeccion.class)
public class TipoPostSeccion_ { 

    public static volatile SingularAttribute<TipoPostSeccion, TipoPostSeccionPK> tipoPostSeccionPK;
    public static volatile SingularAttribute<TipoPostSeccion, TipoPost> tipoPost;
    public static volatile SingularAttribute<TipoPostSeccion, Integer> peso;
    public static volatile SingularAttribute<TipoPostSeccion, Boolean> obligatorio;
    public static volatile SingularAttribute<TipoPostSeccion, Boolean> activo;

}