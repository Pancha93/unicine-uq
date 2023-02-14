package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,Integer> {
//todas las consultas tienen un metodo de prueba
    @Query("select c from Cliente c where c.correo =?1")
    Cliente obtener(String email);

//esta es otra forma de buscar el cliente por correo
    Cliente findAllByCorreo(String email);

    @Query("select c from Cliente  c where c.correo = :correo and c.password = :password")
    Cliente ComprobarAutenticacion(String correo,String password);

    //esta es otra forma de buscar el cliente por correo y contraseña
    Cliente findByCorreoAndPassword(String correo,String passowrd);

    @Query("select c from Cliente c where c.estado = :estado")
    List<Cliente> ObtenerPorEstado(boolean estado, Pageable paginador);
}
