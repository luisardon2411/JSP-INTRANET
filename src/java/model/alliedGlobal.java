
package model;

/**
 *
 * @author Luis
 */
public class alliedGlobal {
    private int id;
    private String skill, encargado, correo;

    public alliedGlobal() {
    }

    public alliedGlobal(String skill, String encargado, String correo) {
        this.skill = skill;
        this.encargado = encargado;
        this.correo = correo;
    }

    public alliedGlobal(int id, String skill, String encargado, String correo) {
        this.id = id;
        this.skill = skill;
        this.encargado = encargado;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
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
