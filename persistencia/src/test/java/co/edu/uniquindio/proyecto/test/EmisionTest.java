package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Emision;
import co.edu.uniquindio.proyecto.repositorios.EmisionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmisionTest {

    @Autowired
    private EmisionRepo emisionRepo;

    //Test para ingresar
    @Test
    public void ingresarEmisionTest() {
        Emision newEmision = new Emision(3, 323.2, "tCO2eq");
        Emision saveEmision = emisionRepo.save(newEmision);

        Assertions.assertNotNull(saveEmision);
    }

    //Test para eliminar
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarEmisionTest() {
        emisionRepo.deleteById(1);
        Emision emisionDelete = emisionRepo.findById(1).orElse(null);

        Assertions.assertNull(emisionDelete);
    }

    //Test para actualizar
    @Test
    @Sql("classpath:dataSet.sql")
    public void actualizarEmisionTest() {
        Emision emisionSaved = emisionRepo.findById(1).orElse(null);
        assert emisionSaved != null;
        emisionSaved.setValor(234.5);
        emisionRepo.save(emisionSaved);

        Emision emisionUpdate = emisionRepo.getById(1);
        Assertions.assertEquals(234.5, emisionUpdate.getValor());
    }

    //Test para listar
    @Test
    @Sql("classpath:dataset.sql")
    public void listarEmisionesTest() {
        List<Emision> emisiones = emisionRepo.findAll();
        emisiones.forEach(a -> System.out.println(a));
    }
}