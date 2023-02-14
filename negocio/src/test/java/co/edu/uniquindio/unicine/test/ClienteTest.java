package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar(){

        ArrayList<String> telefonos = new ArrayList<>();
        telefonos.add("7372403");
        telefonos.add("3128821606");

        Cliente cliente = new Cliente("pancha","pancha@gmail.com", "123",  "scdsvf.com", telefonos);

        Cliente guardado = clienteRepo.save(cliente);

        Assertions.assertNotNull(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){

        Cliente buscado = clienteRepo.findById(1).orElse(null);

        clienteRepo.delete(buscado);

        Assertions.assertNull(clienteRepo.findById(1).orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){

        Cliente guardado = clienteRepo.findById(4).orElse(null);
        guardado.setCorreo("liseth@hotmail.com");
        Cliente nuevo = clienteRepo.save(guardado);

        Assertions.assertArrayEquals("liseth@hotmail.com".toCharArray(), nuevo.getCorreo().toCharArray());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){

        Optional<Cliente> buscado = clienteRepo.findById(4);

        Assertions.assertNotNull(buscado.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){

        List<Cliente> lista = clienteRepo.findAll();
        lista.forEach(System.out::println);

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void ObtenerPorCorreo(){
        Cliente cliente = clienteRepo.obtener("sant@gmail.com");
        Assertions.assertNotNull(cliente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void ComporbarAutenticacion(){
        Cliente cliente = clienteRepo.ComprobarAutenticacion("sant@gmail.com","765");
        Assertions.assertNotNull(cliente);
    }

    //sirve para mostrar por ejemplo los 3 primeros clientes
    @Test
    @Sql("classpath:dataset.sql")
    public void Paginador(){
        List<Cliente> clientes = clienteRepo.findAll(PageRequest.of(0,3)).toList();
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void PaginadorEstado(){
        List<Cliente> clientes = clienteRepo.ObtenerPorEstado(true,PageRequest.of(0,3));
        clientes.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void OrdenarRegistros(){
        List<Cliente> clientes = clienteRepo.findAll(Sort.by("nombre"));
        clientes.forEach(System.out::println);
    }

    //se puede combinar el sort con el paginador

}

