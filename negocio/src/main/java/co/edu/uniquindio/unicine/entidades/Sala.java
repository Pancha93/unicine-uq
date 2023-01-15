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
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "sala")
    private List<Funcion> funciones;

    @OneToMany(mappedBy = "sala")
    private List<SillaSala> sillaSalas;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Teatro teatro;

    @Builder
    public Sala(String nombre, Teatro teatro) {
        this.nombre = nombre;
        this.teatro = teatro;
    }
}
