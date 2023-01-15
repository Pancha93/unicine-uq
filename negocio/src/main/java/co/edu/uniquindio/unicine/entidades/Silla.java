package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Silla implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private int numero;

    @Column(nullable = false)
    private String fila;

    @Column(nullable = false)
    private String columna;

    @OneToMany(mappedBy = "silla")
    private List<SillaSala> sillaSalas;

    @Builder
    public Silla(int numero, String fila, String columna) {
        this.numero = numero;
        this.fila = fila;
        this.columna = columna;
    }
}
