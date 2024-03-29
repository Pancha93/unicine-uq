package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Confiteria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String nombre;

    @Positive
    @Column(nullable = false)
    private float precio;

    @Column(nullable = false)
    private String url_imagen;

    @ManyToMany(mappedBy = "confiteria")
    private List<Compra> compras;

    @Builder
    public Confiteria(String nombre, float precio, String url_imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.url_imagen = url_imagen;
    }
}
