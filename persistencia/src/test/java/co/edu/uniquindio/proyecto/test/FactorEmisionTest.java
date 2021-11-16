package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Emision;
import co.edu.uniquindio.proyecto.entidades.FactorEmision;
import co.edu.uniquindio.proyecto.repositorios.FactorEmisionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FactorEmisionTest {

    @Autowired
    private FactorEmisionRepo factorEmisionRepo;

    //Test para ingresar
    @Test
    public void ingresarFactorEmisionTest() {
        FactorEmision newFactorEmision = new FactorEmision(3, 0.34, "tCO2eq/kg");
        FactorEmision saveFactorEmision = factorEmisionRepo.save(newFactorEmision);

        Assertions.assertNotNull(saveFactorEmision);
    }

    //Test para eliminar
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarFactorEmisionTest() {
        factorEmisionRepo.deleteById(1);
        FactorEmision factorEmisionDelete = factorEmisionRepo.findById(1).orElse(null);

        Assertions.assertNull(factorEmisionDelete);
    }

    //Test para actualizar
    @Test
    @Sql("classpath:dataSet.sql")
    public void actualizarFactorEmisionTest() {
        FactorEmision factorEmisionSaved = factorEmisionRepo.findById(1).orElse(null);
        assert factorEmisionSaved != null;
        factorEmisionSaved.setValor(1.61);
        factorEmisionRepo.save(factorEmisionSaved);

        FactorEmision factorEmisionUpdate = factorEmisionRepo.getById(1);
        Assertions.assertEquals(1.61, factorEmisionUpdate.getValor());
    }

    //Test para listar
    @Test
    @Sql("classpath:dataset.sql")
    public void listarFactoresEmisionTest() {
        List<FactorEmision> factoresEmision = factorEmisionRepo.findAll();
        factoresEmision.forEach(a -> System.out.println(a));
    }
}
