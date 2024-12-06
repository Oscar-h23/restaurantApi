package pe.idat.restaurantAPI.Entity;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private String producto;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }
}