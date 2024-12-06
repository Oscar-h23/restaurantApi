package pe.idat.restaurantAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.idat.restaurantAPI.Entity.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombreContainingIgnoreCase(String nombre);
}