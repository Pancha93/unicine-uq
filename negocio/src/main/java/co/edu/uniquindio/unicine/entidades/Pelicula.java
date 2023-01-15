package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false)
    private String sipnosis;

    @Column(nullable = false)
    private String url_trailer;

    @Column(nullable = false)
    private  String url_imagen;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private  String reparto;

    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;

    @Builder
    public Pelicula(String nombre, String sipnosis, String url_trailer, String url_imagen, String estado, String reparto) {
        this.nombre = nombre;
        this.sipnosis = sipnosis;
        this.url_trailer = url_trailer;
        this.url_imagen = url_imagen;
        this.estado = estado;
        this.reparto = reparto;
    }
}
