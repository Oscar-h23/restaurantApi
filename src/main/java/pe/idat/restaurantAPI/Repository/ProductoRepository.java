package pe.idat.restaurantAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.idat.restaurantAPI.Entity.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}