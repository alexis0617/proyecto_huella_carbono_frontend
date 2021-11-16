package co.edu.uniquindio.proyecto.test;

import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    private UsuarioRepo usuarioRepo;

    //Test para ingresar
    @Test
    public void ingresarUsuarioTest() {
        Usuario newUsuario = new Usuario(2, "Juanda", "3243", "Desarrollador");
        Usuario saveUsuario = usuarioRepo.save(newUsuario);

        Assertions.assertNotNull(saveUsuario);
    }

    //Test para eliminar
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarUsuarioTest() {
        usuarioRepo.deleteById(1);
        Usuario usuarioDelete = usuarioRepo.findById(1).orElse(null);

        Assertions.assertNull(usuarioDelete);
    }

    //Test para actualizar
    @Test
    @Sql("classpath:dataSet.sql")
    public void actualizarUsuarioTest() {
        Usuario usuarioSaved = usuarioRepo.findById(1).orElse(null);
        assert usuarioSaved != null;
        usuarioSaved.setPassword("9876");
        usuarioRepo.save(usuarioSaved);

        Usuario usuarioUpdate = usuarioRepo.getById(1);
        Assertions.assertEquals("9876", usuarioUpdate.getPassword());
    }

    //Test para listar
    @Test
    @Sql("classpath:dataset.sql")
    public void listarUsuariosTest() {
        List<Usuario> usuarios = usuarioRepo.findAll();
        usuarios.forEach(System.out::println);
    }
}
