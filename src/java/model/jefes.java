
package model;


/**
 *
 * @author Luis
 */
public class jefes {
    private int idJefes,idEstado,idPais;
    private String cod_emp, nombre_emp,email,estado,pais;

    public jefes() {
    }

    public jefes(int idJefes, String cod_emp, String nombre_emp, String email, String estado, String pais) {
        this.idJefes = idJefes;
        this.cod_emp = cod_emp;
        this.nombre_emp = nombre_emp;
        this.email = email;
        this.estado = estado;
        this.pais = pais;
    }

    public jefes(int idEstado, int idPais, String cod_emp, String nombre_emp, String email) {
        this.idEstado = idEstado;
        this.idPais = idPais;
        this.cod_emp = cod_emp;
        this.nombre_emp = nombre_emp;
        this.email = email;
    }

    public jefes(int idJefes, int idEstado) {
        this.idJefes = idJefes;
        this.idEstado = idEstado;
    }
    
    public int getIdJefes() {
        return idJefes;
    }

    public void setIdJefes(int idJefes) {
        this.idJefes = idJefes;
    }

    public String getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(String cod_emp) {
        this.cod_emp = cod_emp;
    }

    public String getNombre_emp() {
        return nombre_emp;
    }

    public void setNombre_emp(String nombre_emp) {
        this.nombre_emp = nombre_emp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}
