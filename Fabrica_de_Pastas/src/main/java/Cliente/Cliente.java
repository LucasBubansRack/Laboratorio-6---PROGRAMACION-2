package Cliente;

import PedidoInvalido.PedidoInvalidoException;

public class Cliente {

    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private String direccion;

    public Cliente() {
    }

    public Cliente(String nombre, String direccion, String telefono, String mail, String apellido)
        throws PedidoInvalidoException {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.apellido = apellido;

        validarDatos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void validarDatos(){
        if (nombre == null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        } else if (nombre.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no puede contener números");
        }
        if (apellido == null || apellido.trim().isEmpty()){
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        } else if (apellido.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El apellido no puede contener números");
        }
    }
}
