package sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Post;

@Stateless
public class PostFacade extends AbstractFacade<Post> implements PostFacadeLocal {

    @PersistenceContext(unitName = "guia5")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }
    
}
