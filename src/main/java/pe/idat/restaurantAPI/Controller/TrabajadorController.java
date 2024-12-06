package pe.idat.restaurantAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.idat.restaurantAPI.Entity.Trabajador;
import pe.idat.restaurantAPI.Repository.TrabajadorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorController {
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @GetMapping
    public List<Trabajador> listarTrabajadores() {
        return trabajadorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> obtenerTrabajador(@PathVariable Long id) {
        return trabajadorRepository.findById(id)
                .map(trabajador -> ResponseEntity.ok().body(trabajador))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Trabajador crearTrabajador(@RequestBody Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> actualizarTrabajador(@PathVariable Long id, @RequestBody Trabajador trabajadorDetails) {
        return trabajadorRepository.findById(id)
                .map(trabajador -> {
                    trabajador.setNombre(trabajadorDetails.getNombre());
                    trabajador.setPuesto(trabajadorDetails.getPuesto());
                    return ResponseEntity.ok(trabajadorRepository.save(trabajador));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTrabajador(@PathVariable Long id) {
        return trabajadorRepository.findById(id)
                .<ResponseEntity<Void>>map(trabajador -> {
                    trabajadorRepository.delete(trabajador);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/buscar")
    public List<Trabajador> buscarTrabajadoresPorNombre(@RequestParam String nombre) {
        return trabajadorRepository.findByNombreContainingIgnoreCase(nombre);
    }
}