
package model;

/**
 *
 * @author Luis
 */
public class internos {
    private String cod_emp, nombre_emp, apellido_emp, fecha_nac, diu, email, observaciones, estado, pais,correoJefe,nombreJefe,codJefe,sede;
    private int idestado, idpais,idjefe,idinternos;

    public internos() {
    }

    public internos(int idinternos, String cod_emp, String nombre_emp, String apellido_emp, String fecha_nac, String diu, String email, String observaciones, String estado, String pais, String correoJefe, String nombreJefe, String codJefe, String sede) {
        this.idinternos = idinternos;
        this.cod_emp = cod_emp;
        this.nombre_emp = nombre_emp;
        this.apellido_emp = apellido_emp;
        this.fecha_nac = fecha_nac;
        this.diu = diu;
        this.email = email;
        this.observaciones = observaciones;
        this.estado = estado;
        this.pais = pais;
        this.correoJefe = correoJefe;
        this.nombreJefe = nombreJefe;
        this.codJefe = codJefe;
        this.sede = sede;
    }

    public internos(String cod_emp, String nombre_emp, String apellido_emp, String fecha_nac, String diu, String email, String observaciones,String sede, int idestado, int idpais, int idjefe) {
        this.cod_emp = cod_emp;
        this.nombre_emp = nombre_emp;
        this.apellido_emp = apellido_emp;
        this.fecha_nac = fecha_nac;
        this.diu = diu;
        this.email = email;
        this.observaciones = observaciones;
        this.sede = sede;
        this.idestado = idestado;
        this.idpais = idpais;
        this.idjefe = idjefe;
    }

    public internos(String observaciones, String sede, int idestado, int idjefe, int idinternos) {
        this.observaciones = observaciones;
        this.sede = sede;
        this.idestado = idestado;
        this.idjefe = idjefe;
        this.idinternos = idinternos;
    }
    

    public internos(int idjefe) {
        this.idjefe = idjefe;
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

    public String getApellido_emp() {
        return apellido_emp;
    }

    public void setApellido_emp(String apellido_emp) {
        this.apellido_emp = apellido_emp;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDiu() {
        return diu;
    }

    public void setDiu(String diu) {
        this.diu = diu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCorreoJefe() {
        return correoJefe;
    }

    public void setCorreoJefe(String correoJefe) {
        this.correoJefe = correoJefe;
    }

    public String getNombreJefe() {
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
    }

    public String getCodJefe() {
        return codJefe;
    }

    public void setCodJefe(String codJefe) {
        this.codJefe = codJefe;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }

    public int getIdjefe() {
        return idjefe;
    }

    public void setIdjefe(int idjefe) {
        this.idjefe = idjefe;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getIdinternos() {
        return idinternos;
    }

    public void setIdinternos(int idinternos) {
        this.idinternos = idinternos;
    }
    
    
}
