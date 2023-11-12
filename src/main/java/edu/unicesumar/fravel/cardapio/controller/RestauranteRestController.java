package edu.unicesumar.fravel.cardapio.controller;

import edu.unicesumar.fravel.cardapio.model.restaurante.Restaurante;
import edu.unicesumar.fravel.cardapio.model.restaurante.RestauranteService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurante")
public class RestauranteRestController {

    private final RestauranteService restauranteService;

    public RestauranteRestController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping()
    public ResponseEntity<Restaurante> criaRestaurante(@RequestBody Restaurante restaurante) {
        final Restaurante restauranteCreated = restauranteService.criarEstabelecimento(restaurante);
        return new ResponseEntity<>(restauranteCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Restaurante>> pageableRestaurantes() {
        final Page<Restaurante> restaurantesPageable = restauranteService.pageable();
        return new ResponseEntity<>(restaurantesPageable, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> findById(@PathVariable Long id) {
        final Restaurante find = restauranteService.findById(id);
        return new ResponseEntity<>(find, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletaRestaurante(@PathVariable Long id) {
        restauranteService.deletaRestaurante(id);
        return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurante> editaRestaurante(@PathVariable Long id, @RequestBody Restaurante restaurante) {
        final Restaurante editaRestaurante = restauranteService.editaRestaurante(id, restaurante);
        return new ResponseEntity<>(editaRestaurante, HttpStatus.OK);
    }

}
