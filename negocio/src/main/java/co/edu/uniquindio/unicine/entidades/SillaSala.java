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

public class SillaSala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Positive
    @Column(nullable = false)
    private float precio;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Sala sala;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Silla silla;

    @ManyToMany(mappedBy = "sillaSalas")
    private List<Compra> compras;

    @Builder
    public SillaSala(float precio, Sala sala, Silla silla) {
        this.precio = precio;
        this.sala = sala;
        this.silla = silla;
    }
}
