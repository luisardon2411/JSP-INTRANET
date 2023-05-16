
package model;

/**
 *
 * @author Luis
 */
public class representantes {
    private int idDistribuidor, idPais;
    private String codDist,nombreDistribuidor, encargado, email, pais;

    public representantes() {
    }

    public representantes(int idDistribuidor, int idPais, String codDist, String nombreDistribuidor, String encargado, String email) {
        this.idDistribuidor = idDistribuidor;
        this.idPais = idPais;
        this.codDist = codDist;
        this.nombreDistribuidor = nombreDistribuidor;
        this.encargado = encargado;
        this.email = email;
    }

    public representantes(int idDistribuidor, String codDist, String nombreDistribuidor, String encargado, String email, String pais) {
        this.idDistribuidor = idDistribuidor;
        this.codDist = codDist;
        this.nombreDistribuidor = nombreDistribuidor;
        this.encargado = encargado;
        this.email = email;
        this.pais = pais;
    }

    public representantes(int idDistribuidor, String encargado, String email) {
        this.idDistribuidor = idDistribuidor;
        this.encargado = encargado;
        this.email = email;
    }

    public representantes(int idPais, String codDist, String nombreDistribuidor, String encargado, String email) {
        this.idPais = idPais;
        this.codDist = codDist;
        this.nombreDistribuidor = nombreDistribuidor;
        this.encargado = encargado;
        this.email = email;
    }
    
    public representantes(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public representantes(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }
    

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombreDistribuidor() {
        return nombreDistribuidor;
    }

    public void setNombreDistribuidor(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodDist() {
        return codDist;
    }

    public void setCodDist(String codDist) {
        this.codDist = codDist;
    }
    
    
    
}
