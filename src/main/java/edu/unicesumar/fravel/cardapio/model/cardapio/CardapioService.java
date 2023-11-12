package edu.unicesumar.fravel.cardapio.model.cardapio;

import edu.unicesumar.fravel.cardapio.model.cardapio.Cardapio;
import edu.unicesumar.fravel.cardapio.model.cardapio.CardapioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CardapioService {
    private final CardapioRepository cardapioRepository;


    public CardapioService(CardapioRepository cardapioRepository) {
        this.cardapioRepository = cardapioRepository;
    }

    public Cardapio criar(Cardapio cardapio) {
        return cardapioRepository.save(cardapio);
    }

    public Page<Cardapio> pageable() {
        return cardapioRepository.findAll(Pageable.ofSize(20));
    }

    public Cardapio findById(Long id) {
        return cardapioRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Cardapio não encontrado")
                );
    }

    public void deletaCardapio(Long id) {
        cardapioRepository.deleteById(id);
    }

    public Cardapio editaCardapio(Long id, Cardapio cardapioEditado) {
        final Cardapio cardapio = findById(id);
//        if (cardapioEditado.getPratos() != null) cardapio.setPratos(cardapioEditado.getPratos());
        final Cardapio cardapioEditaded = cardapioRepository.save(cardapio);
        return cardapioEditaded;
    }
}
