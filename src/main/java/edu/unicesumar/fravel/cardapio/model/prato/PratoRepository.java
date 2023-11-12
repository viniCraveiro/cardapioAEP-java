package edu.unicesumar.fravel.cardapio.model.prato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {
}
