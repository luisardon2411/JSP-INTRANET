package model;


public class usuarios {
   private String usuario, contraseña, cod_emp, nombre_user,apellido_user,tipoUsuario,estado,fecha_envio,numero_telefonico;
   private String fecha_reg, ultima_session;
   private int idEstado, idTipoUsuario;

    public usuarios() {
    }

    public usuarios(String usuario, String contraseña, String cod_emp, String nombre_user, String apellido_user,String numero_telefonico, int idEstado, int idTipoUsuario) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cod_emp = cod_emp;
        this.nombre_user = nombre_user;
        this.apellido_user = apellido_user;
        this.numero_telefonico = numero_telefonico;
        this.idEstado = idEstado;
        this.idTipoUsuario = idTipoUsuario;
    }

    public usuarios(String usuario, String contraseña, String cod_emp, String nombre_user, String apellido_user, String fecha_envio) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cod_emp = cod_emp;
        this.nombre_user = nombre_user;
        this.apellido_user = apellido_user;
        this.fecha_envio = fecha_envio;
    }
    public usuarios(String usuario, String contraseña, String cod_emp, String nombre_user, String apellido_user) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cod_emp = cod_emp;
        this.nombre_user = nombre_user;
        this.apellido_user = apellido_user;
    }

    public usuarios(String usuario, String contraseña, String cod_emp, String nombre_user, String apellido_user, String tipoUsuario, String estado, String fecha_reg, String ultima_session) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.cod_emp = cod_emp;
        this.nombre_user = nombre_user;
        this.apellido_user = apellido_user;
        
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
        this.fecha_reg = fecha_reg;
        this.ultima_session = ultima_session;
    }

    public usuarios(String usuario, String cod_emp, String nombre_user, String apellido_user) {
        this.usuario = usuario;
        this.cod_emp = cod_emp;
        this.nombre_user = nombre_user;
        this.apellido_user = apellido_user;
    }



    public usuarios(String usuario, String cod_emp, String nombre_user, String apellido_user,String numero_telefonico, String tipoUsuario, String estado, String ultima_session) {
        this.usuario = usuario;
        this.cod_emp = cod_emp;
        this.nombre_user = nombre_user;
        this.apellido_user = apellido_user;
        this.numero_telefonico = numero_telefonico;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
        this.ultima_session = ultima_session;
    }

    public usuarios(String usuario, int idEstado, int idTipoUsuario) {
        this.usuario = usuario;
        this.idEstado = idEstado;
        this.idTipoUsuario = idTipoUsuario;
    }
    
    public usuarios(String usuario) {
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(String fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public String getFecha_reg() {
        return fecha_reg;
    }

    public void setFecha_reg(String fecha_reg) {
        this.fecha_reg = fecha_reg;
    }

    public String getUltima_session() {
        return ultima_session;
    }

    public void setUltima_session(String ultima_session) {
        this.ultima_session = ultima_session;
    }

    public String getNumero_telefonico() {
        return numero_telefonico;
    }

    public void setNumero_telefonico(String numero_telefonico) {
        this.numero_telefonico = numero_telefonico;
    }
    
    
      
}
