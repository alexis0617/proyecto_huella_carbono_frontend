package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Consumo;
import co.edu.uniquindio.proyecto.entidades.Residuo;
import co.edu.uniquindio.proyecto.entidades.TipoConsumo;
import co.edu.uniquindio.proyecto.entidades.TipoResiduo;
import co.edu.uniquindio.proyecto.repositorios.ResiduoRepo;
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
public class ResiduoTest {

    @Autowired
    private ResiduoRepo residuoRepo;

    //Test para ingresar
    @Test
    public void ingresarResiduoTest() {
        Residuo newResiduo = new Residuo(2, TipoResiduo.ORGANICOS, 119701.2, "kg/año",
                "Sistema de Gestion Ambiental", LocalDate.of(2021, 11, 15),
                "Promedio mesual 2017-20-21");
        Residuo saveResiduo = residuoRepo.save(newResiduo);

        Assertions.assertNotNull(saveResiduo);
    }

    //Test para eliminar
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarResiduoTest() {
        residuoRepo.deleteById(1);
        Residuo residuoDelete = residuoRepo.findById(2).orElse(null);

        Assertions.assertNull(residuoDelete);
    }

    //Test para actualizar
    @Test
    @Sql("classpath:dataSet.sql")
    public void actualizarResiduoTest() {
        Residuo residuoSaved = residuoRepo.findById(1).orElse(null);
        assert residuoSaved != null;
        residuoSaved.setGeneracion(4323.5);
        residuoRepo.save(residuoSaved);

        Residuo residuoUpdate = residuoRepo.getById(1);
        Assertions.assertEquals(4323.5, residuoUpdate.getGeneracion());
    }

    //Test para listar
    @Test
    @Sql("classpath:dataset.sql")
    public void listarResiduosTest() {
        List<Residuo> residuos = residuoRepo.findAll();
        residuos.forEach(System.out::println);
    }
}
