package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Dependencia implements Serializable {

    //ATRIBUTOS PROPIOS DE LA ENTIDAD
    @Id
    private Integer codigo;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 255, nullable = true)
    private String descripcion;

    //RELACIONES ENTRE ENTIDADES
    @OneToOne(mappedBy = "dependencia")
    private Usuario usuario;

    //CONSTRUCTOR
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
