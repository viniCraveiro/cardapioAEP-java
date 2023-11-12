package edu.unicesumar.fravel.cardapio.controller;

import edu.unicesumar.fravel.cardapio.model.prato.Prato;
import edu.unicesumar.fravel.cardapio.model.prato.PratoService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prato")
public class PratoRestController {

    private final PratoService pratoService;


    public PratoRestController(PratoService pratoService) {
        this.pratoService = pratoService;
    }

    @PostMapping()
    public ResponseEntity<Prato> criaPrato(@RequestBody Prato prato) {
        final Prato created = pratoService.criar(prato);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Prato>> pageablePratos() {
        final Page<Prato> pratosPageable = pratoService.pageable();
        return new ResponseEntity<>(pratosPageable, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prato> findById(@PathVariable Long id) {
        final Prato find = pratoService.findById(id);
        return new ResponseEntity<>(find, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletaPrato(@PathVariable Long id){
        pratoService.deletaPrato(id);
        return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prato> editaPrato(@PathVariable Long id, @RequestBody Prato prato){
        final Prato editaPrato = pratoService.editaPrato(id, prato);
        return new ResponseEntity<>(editaPrato, HttpStatus.OK);
    }


}
