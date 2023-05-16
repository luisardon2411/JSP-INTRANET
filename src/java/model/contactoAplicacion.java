
package model;

/**
 *
 * @author Luis
 */
public class contactoAplicacion {
    private int id;
    private String aplicacion, encargado, correo;

    public contactoAplicacion() {
    }

    public contactoAplicacion(int id, String aplicacion, String encargado, String correo) {
        this.id = id;
        this.aplicacion = aplicacion;
        this.encargado = encargado;
        this.correo = correo;
    }

    public contactoAplicacion(String aplicacion, String encargado, String correo) {
        this.aplicacion = aplicacion;
        this.encargado = encargado;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
