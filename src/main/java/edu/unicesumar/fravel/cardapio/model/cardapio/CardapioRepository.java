package edu.unicesumar.fravel.cardapio.model.cardapio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
