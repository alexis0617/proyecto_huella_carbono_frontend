package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
public class Consumo implements Serializable {

    //ATRIBUTOS PROPIOS DE LA ENTIDAD
    @Id
    private Integer id;

    @Column(nullable = false, name = "tipo_consumo")
    private TipoConsumo tipoConsumo;

    @Column(nullable = false)
    private double cantidad;

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
    public Consumo(int id, TipoConsumo tipoConsumo, double cantidad, String unidadMedida, String fuente, LocalDate fecha, String observaciones) {
        this.id = id;
        this.tipoConsumo = tipoConsumo;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.fuente = fuente;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }
}
