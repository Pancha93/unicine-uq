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
public class AdministradorTeatro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false,length = 100)
    private String correo;

    @Column(nullable = false, length = 20)
    private String password;

    @OneToMany(mappedBy = "administrador")
    private List<Teatro> teatros;

    @Builder
    public AdministradorTeatro(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }
}
