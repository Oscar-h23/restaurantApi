package pe.idat.restaurantAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.idat.restaurantAPI.Entity.Pedido;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByProductoContainingIgnoreCase(String producto);

}