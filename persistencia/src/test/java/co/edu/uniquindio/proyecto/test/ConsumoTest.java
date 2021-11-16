package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Consumo;
import co.edu.uniquindio.proyecto.entidades.TipoConsumo;
import co.edu.uniquindio.proyecto.repositorios.ConsumoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConsumoTest {

    @Autowired
    private ConsumoRepo consumoRepo;    //Test para ingresar

    @Test
    public void ingresarConsumoTest() {
        Consumo newConsumo = new Consumo(2, TipoConsumo.ENERGIA_ELECTRICA, 119701.2, "kw-h/mes",
                "Sistema de Gestion Ambiental", LocalDate.of(2021, 11, 15),
                "Promedio mesual 2017-20-21");
        Consumo saveConsumo = consumoRepo.save(newConsumo);

        Assertions.assertNotNull(saveConsumo);
    }

    //Test para eliminar
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarConsumoTest() {
        consumoRepo.deleteById(1);
        Consumo consumoDelete = consumoRepo.findById(2).orElse(null);

        Assertions.assertNull(consumoDelete);
    }

    //Test para actualizar
    @Test
    @Sql("classpath:dataSet.sql")
    public void actualizarConsumoTest() {
        Consumo consumoSaved = consumoRepo.findById(1).orElse(null);
        assert consumoSaved != null;
        consumoSaved.setCantidad(10);
        consumoRepo.save(consumoSaved);

        Consumo consumoUpdate = consumoRepo.getById(1);
        Assertions.assertEquals(10, consumoUpdate.getCantidad());
    }

    //Test para listar
    @Test
    @Sql("classpath:dataset.sql")
    public void listarConsumosTest() {
        List<Consumo> consumos = consumoRepo.findAll();
        consumos.forEach(System.out::println);
    }


}
