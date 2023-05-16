
package model;

/**
 *
 * @author Luis
 */
public class solicitudes {
    private String usuario, contraseña, cod_emp, nombre_user, apellido_user, fecha_envio, estado;

    public solicitudes() {
    }

    public solicitudes(String usuario, String contraseña, String cod_emp, String nombre_user, String apellido_user) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cod_emp = cod_emp;
        this.nombre_user = nombre_user;
        this.apellido_user = apellido_user;
    }

    public solicitudes(String usuario, String contraseña, String cod_emp, String nombre_user, String apellido_user, String fecha_envio) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cod_emp = cod_emp;
        this.nombre_user = nombre_user;
        this.apellido_user = apellido_user;
        this.fecha_envio = fecha_envio;
    }

    public solicitudes(String usuario, String contraseña, String cod_emp, String nombre_user, String apellido_user, String fecha_envio, String estado) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cod_emp = cod_emp;
        this.nombre_user = nombre_user;
        this.apellido_user = apellido_user;
        this.fecha_envio = fecha_envio;
        this.estado = estado;
    }

    public solicitudes(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(String cod_emp) {
        this.cod_emp = cod_emp;
    }

    public String getNombre_user() {
        return nombre_user;
    }

    public void setNombre_user(String nombre_user) {
        this.nombre_user = nombre_user;
    }

    public String getApellido_user() {
        return apellido_user;
    }

    public void setApellido_user(String apellido_user) {
        this.apellido_user = apellido_user;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
