package appmoviles.com.appsmoviles20191.model;

public class Amigo {

    //----------------------------------------
    //Atributos
    //----------------------------------------
    private String id;
    private String correo;
    private String nombre;
    private String edad;
    private String telefono;
    //----------------------------------------
    //Constructor
    //----------------------------------------

    //Serializar
    public Amigo() {
    }

    public Amigo(String id, String nombre, String edad,String correo, String telefono) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
    }
    //----------------------------------------
    //Metodos
    //----------------------------------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
