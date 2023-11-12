package edu.unicesumar.fravel.cardapio.controller;

import edu.unicesumar.fravel.cardapio.model.cardapio.Cardapio;
import edu.unicesumar.fravel.cardapio.model.cardapio.CardapioService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cardapio")
public class CardapioRestController {

    private final CardapioService cardapioService;

    public CardapioRestController(CardapioService cardapioService) {
        this.cardapioService = cardapioService;
    }

    @PostMapping()
    public ResponseEntity<Cardapio> criaCardapio(@RequestBody Cardapio cardapio) {
        final Cardapio cardapioCreated = cardapioService.criar(cardapio);
        return new ResponseEntity<>(cardapioCreated, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Cardapio>> pageableCardapios() {
        final Page<Cardapio> cardapiosPageable = cardapioService.pageable();
        return new ResponseEntity<>(cardapiosPageable, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cardapio> findById(@PathVariable Long id) {
        final Cardapio find = cardapioService.findById(id);
        return new ResponseEntity<>(find, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletaCardapio(@PathVariable Long id) {
        cardapioService.deletaCardapio(id);
        return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cardapio> editaCardapio(@PathVariable Long id, @RequestBody Cardapio cardapio) {
        final Cardapio editaCardapio = cardapioService.editaCardapio(id, cardapio);
        return new ResponseEntity<>(editaCardapio, HttpStatus.OK);
    }

}
