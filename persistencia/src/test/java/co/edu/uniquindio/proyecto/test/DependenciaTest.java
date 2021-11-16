package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Consumo;
import co.edu.uniquindio.proyecto.entidades.Dependencia;
import co.edu.uniquindio.proyecto.repositorios.DependenciaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DependenciaTest {

    @Autowired
    private DependenciaRepo dependenciaRepo;

    //Test para ingresar
    @Test
    public void ingresarDependenciaTest() {
        Dependencia newDependencia = new Dependencia(2, "Planificacion Uq", "Dependencia de la universidad del quindio");
        Dependencia saveDependencia = dependenciaRepo.save(newDependencia);

        Assertions.assertNotNull(saveDependencia);
    }

    //Test para eliminar
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarConsumoTest() {
        dependenciaRepo.deleteById(1);
        Dependencia dependenciaDelete = dependenciaRepo.findById(2).orElse(null);

        Assertions.assertNull(dependenciaDelete);
    }

    //Test para actualizar
    @Test
    @Sql("classpath:dataSet.sql")
    public void actualizarDependenciaTest() {
        Dependencia dependenciaSaved = dependenciaRepo.findById(1).orElse(null);
        assert dependenciaSaved != null;
        dependenciaSaved.setDescripcion("Programa de Ingenieria en Sistemas y Computacion");
        dependenciaRepo.save(dependenciaSaved);

        Dependencia dependenciaUpdate = dependenciaRepo.getById(1);
        Assertions.assertEquals("Programa de Ingenieria en Sistemas y Computacion", dependenciaUpdate.getDescripcion());
    }

    //Test para listar
    @Test
    @Sql("classpath:dataset.sql")
    public void listarDependenciasTest() {
        List<Dependencia> dependencias = dependenciaRepo.findAll();
        dependencias.forEach(a -> System.out.println(a));
    }
}
