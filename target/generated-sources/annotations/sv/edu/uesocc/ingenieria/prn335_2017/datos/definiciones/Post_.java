package sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-25T17:41:59")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, String> descripcion;
    public static volatile SingularAttribute<Post, Date> fecha;
    public static volatile SingularAttribute<Post, TipoPost> idTipoPost;
    public static volatile SingularAttribute<Post, String> titulo;
    public static volatile SingularAttribute<Post, Boolean> aprobacionComentarios;
    public static volatile SingularAttribute<Post, Integer> idPost;

}