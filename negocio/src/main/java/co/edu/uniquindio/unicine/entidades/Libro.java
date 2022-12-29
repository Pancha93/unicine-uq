package co.edu.uniquindio.unicine.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Libro implements Serializable {

    @Id
    private String isbn;

    private String nombre;

    private int unidades;

    private int anio;

    public Libro() {
    }

    public Libro(String isbn, String nombre, int unidades, int unidades1, int anio) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.unidades = unidades;
        this.unidades = unidades1;
        this.anio = anio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
