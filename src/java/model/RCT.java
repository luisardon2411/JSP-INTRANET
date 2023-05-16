package model;

/**
 *
 * @author Luis
 */
public class RCT {
    private String sitio, departamento, ipEnlace,idIp;
    private int idRct;

    public RCT() {
    }

    public RCT(String sitio, String departamento, String ipEnlace, String idIp) {
        this.sitio = sitio;
        this.departamento = departamento;
        this.ipEnlace = ipEnlace;
        this.idIp = idIp;
    }

    public RCT(int idRct) {
        this.idRct = idRct;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getIpEnlace() {
        return ipEnlace;
    }

    public void setIpEnlace(String ipEnlace) {
        this.ipEnlace = ipEnlace;
    }

    public String getIdIp() {
        return idIp;
    }

    public void setIdIp(String idIp) {
        this.idIp = idIp;
    }

    public int getIdRct() {
        return idRct;
    }

    public void setIdRct(int idRct) {
        this.idRct = idRct;
    }
    

    
}
