package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.PostFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.TipoPostFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Post;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.TipoPost;

@Named(value = "frmTipoPost")
@ViewScoped
public class FrmTipoPost implements Serializable {

   @EJB
    private TipoPostFacadeLocal mfl;
    private LazyDataModel<TipoPost> modelo;
    private TipoPost registro;
    private boolean btnadd = true;
    private boolean botones = false;
    private boolean seleccions = false;

    @PostConstruct
    private void inicio() {

        registro = new TipoPost();

        try {
            this.modelo = new LazyDataModel<TipoPost>() {
                @Override
                public Object getRowKey(TipoPost object) {
                    if (object != null) {
                        return object.getIdTipoPost();
                    }
                    return null;
                }

                @Override
                public TipoPost getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (TipoPost reg : (List<TipoPost>) getWrappedData()) {
                                if (reg.getIdTipoPost().compareTo(buscado) == 0) {
                                    return reg;
                                }
                            }
                        } catch (Exception e) {
                            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                        }
                    }
                    return null;
                }

                @Override
                public List<TipoPost> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<TipoPost> salida = new ArrayList();
                    try {
                        if (mfl != null) {
                            this.setRowCount(mfl.count());
                            salida = mfl.findRange(first, pageSize);

                        }
                    } catch (Exception e) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    }
                    return salida;
                }

            };
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    public void guardarRegistro() {
        try {
            if (this.registro != null && this.mfl != null) {
                if (this.mfl.create(registro)) {
                    System.out.println("SE HA AGREGADO CON EXITO!! YA PODEMOS!!");
                    inicio();
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR NO SE AGREGO NADA " + e);
        }
    }

    public void Eliminar() {
        try {

            if (this.registro != null && this.mfl != null) {
                if (this.mfl.remove(registro)) {
                } else {
                    this.registro = new TipoPost();
                    inicio();
                }
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    public void Modificar() {
        try {
            if (this.registro != null && this.mfl != null) {
                if (this.mfl.edit(registro)) {
                    inicio();      
                }
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    public void cancelar() {
        this.registro = new TipoPost();
        this.botones=false;
        this.btnadd=true;  
    }
    
    public void cambiarSeleccion() {
        this.botones = true;
        this.btnadd = false;
    }


    public LazyDataModel<TipoPost> getModelo() {
        return modelo;
    }

    public void setModelo(LazyDataModel<TipoPost> modelo) {
        this.modelo = modelo;
    }

    public TipoPost getRegistro() {
        return registro;
    }

    public void setRegistro(TipoPost registro) {
        this.registro = registro;
    }

    public boolean isBtnadd() {
        return btnadd;
    }

    public void setBtnadd(boolean btnadd) {
        this.btnadd = btnadd;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }

    public boolean isSeleccions() {
        return seleccions;
    }

    public void setSeleccions(boolean seleccions) {
        this.seleccions = seleccions;
    }
    
}