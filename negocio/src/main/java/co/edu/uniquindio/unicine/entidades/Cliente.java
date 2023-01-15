package co.edu.uniquindio.unicine.entidades;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@ToString(callSuper = true)
public class Cliente extends Persona implements Serializable {

    @Column(nullable = false,length = 200)
    private String foto_url;

    @Column(nullable = false)
    private Boolean estado;

    @ElementCollection
    private List<String> telefonos;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Cupon> cupones;

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    @Builder
    public Cliente( String nombre, String correo, String password, String foto_url, List<String> telefonos) {
        super(nombre, correo, password);
        this.foto_url = foto_url;
        this.estado = false;
        this.telefonos = telefonos;

    }
}
