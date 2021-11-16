package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Emision implements Serializable {

    //ATRIBUTOS PROPIOS DE LA ENTIDAD
    @Id
    private Integer id;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false, length = 15)
    private String unidadMedida;

    //RELACIONES ENTRE ENTIDADES
    @OneToOne(mappedBy = "emision")
    private Consumo consumo;

    @OneToOne(mappedBy = "emision")
    private  Residuo residuo;

    //CONSTRUCTOR
    public Emision(int id, double valor, String unidadMedida) {
        this.id = id;
        this.valor = valor;
        this.unidadMedida = unidadMedida;
    }
}
