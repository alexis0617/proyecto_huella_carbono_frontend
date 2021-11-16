package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {

    //ATRIBUTOS PROPIOS DE LA ENTIDAD
    @Id
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(unique = true, nullable = false, length = 20)
    private String username;

    @Column(length = 15, nullable = false)
    @Length(min = 5, max = 15)
    private String password;

    @Column(nullable = false)
    private String rol;

    //RELACIONES ENTRE ENTIDADES
    @OneToOne
    @ToString.Exclude
    private Dependencia dependencia;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Consumo> consumos;

    @OneToMany(mappedBy = "usuario")
    @ToString.Exclude
    private List<Residuo> residuos;

    //CONSTRUCTOR
    public Usuario(int id, String username, String password, String rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
}
