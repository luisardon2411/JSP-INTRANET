package model;

/**
 *
 * @author Luis
 */
public class externos {
    private String nombre_emp, apellido_emp,fecha_nac, diu, email,observaciones, estado, pais, distribuidor,cod_emp,encargado,correo_responsable;
    private int idexterno, idestado, idpais, idDistribuidor;
    
    public externos() {
    }

    public externos(String cod_emp) {
        this.cod_emp = cod_emp;
    }

    public externos(String nombre_emp, String apellido_emp, String fecha_nac, String diu, String email, String observaciones, String cod_emp, int idestado, int idpais, int idDistribuidor) {
        this.nombre_emp = nombre_emp;
        this.apellido_emp = apellido_emp;
        this.fecha_nac = fecha_nac;
        this.diu = diu;
        this.email = email;
        this.observaciones = observaciones;
        this.cod_emp = cod_emp;
        this.idestado = idestado;
        this.idpais = idpais;
        this.idDistribuidor = idDistribuidor;
    }

    public externos(String nombre_emp, String apellido_emp, String fecha_nac, String diu, String email, String observaciones, String estado, String pais, String distribuidor, String cod_emp, String encargado, String correo_responsable, int idexterno) {
        this.nombre_emp = nombre_emp;
        this.apellido_emp = apellido_emp;
        this.fecha_nac = fecha_nac;
        this.diu = diu;
        this.email = email;
        this.observaciones = observaciones;
        this.estado = estado;
        this.pais = pais;
        this.distribuidor = distribuidor;
        this.cod_emp = cod_emp;
        this.encargado = encargado;
        this.correo_responsable = correo_responsable;
        this.idexterno = idexterno;
    }

    public externos(String nombre_emp, String apellido_emp, String fecha_nac, String diu, String email, String observaciones, String cod_emp, int idexterno, int idestado, int idpais, int idDistribuidor) {
        this.nombre_emp = nombre_emp;
        this.apellido_emp = apellido_emp;
        this.fecha_nac = fecha_nac;
        this.diu = diu;
        this.email = email;
        this.observaciones = observaciones;
        this.cod_emp = cod_emp;
        this.idexterno = idexterno;
        this.idestado = idestado;
        this.idpais = idpais;
        this.idDistribuidor = idDistribuidor;
    }

    public externos(String observaciones, int idexterno, int idestado, int idDistribuidor) {
        this.observaciones = observaciones;
        this.idexterno = idexterno;
        this.idestado = idestado;
        this.idDistribuidor = idDistribuidor;
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

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(String cod_emp) {
        this.cod_emp = cod_emp;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getCorreo_responsable() {
        return correo_responsable;
    }

    public void setCorreo_responsable(String correo_responsable) {
        this.correo_responsable = correo_responsable;
    }

    public int getIdexterno() {
        return idexterno;
    }

    public void setIdexterno(int idexterno) {
        this.idexterno = idexterno;
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

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }
    

}
