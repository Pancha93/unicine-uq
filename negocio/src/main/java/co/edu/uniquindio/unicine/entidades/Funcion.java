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
public class Funcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @OneToMany(mappedBy = "funcion")
    private List<Compra> compras;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Horario horario;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Sala sala;

    @Builder
    public Funcion(Pelicula pelicula, Horario horario, Sala sala) {
        this.pelicula = pelicula;
        this.horario = horario;
        this.sala = sala;
    }
}
