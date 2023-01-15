package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Positive
    @Column(nullable = false)
    private float descuento;

    @Column(nullable = false)
    private LocalDate fechaVencimiento;

    @Column(nullable = false)
    private Boolean estado;

    @OneToOne(mappedBy = "cupon")
    private Compra compra;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @Builder
    public Cupon(float descuento, LocalDate fechaVencimiento, Boolean estado, Cliente cliente) {
        this.descuento = descuento;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.cliente = cliente;
    }
}
