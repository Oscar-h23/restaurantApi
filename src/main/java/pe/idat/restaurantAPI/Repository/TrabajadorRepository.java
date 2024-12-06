package pe.idat.restaurantAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.idat.restaurantAPI.Entity.Trabajador;

import java.util.List;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    List<Trabajador> findByNombreContainingIgnoreCase(String nombre);
}