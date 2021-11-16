package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Residuo implements Serializable {

    //ATRIBUTOS PROPIOS DE LA ENTIDAD
    @Id
    private Integer id;

    @Column(nullable = false, name = "tipo_residuo")
    private TipoResiduo tipoResiduo;

    @Column(nullable = false)
    private double generacion;

    @Column(nullable = false, length = 15)
    private String unidadMedida;

    @Column(nullable = false, length = 40)
    private String fuente;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, length = 255)
    private String observaciones;

    //RELACIONES ENTRE ENTIDADES
    @ManyToOne
    private Usuario usuario;

    @OneToOne
    @ToString.Exclude
    private FactorEmision factorEmision;

    @OneToOne
    @ToString.Exclude
    private Emision emision;

    //CONSTRUCTOR
    public Residuo(int id, TipoResiduo tipoResiduo, double generacion, String unidadMedida, String fuente, LocalDate fecha, String observaciones) {
        this.id = id;
        this.tipoResiduo = tipoResiduo;
        this.generacion = generacion;
        this.unidadMedida = unidadMedida;
        this.fuente = fuente;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }
}
