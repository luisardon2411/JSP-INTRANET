
package model;

/**
 *
 * @author Luis
 */
public class paises {
    private int idPais; 
    private String pais;

    public paises() {
    }

    public paises(int idPais, String pais) {
        this.idPais = idPais;
        this.pais = pais;
    }

    public paises(String pais) {
        this.pais = pais;
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
