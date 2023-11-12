package edu.unicesumar.fravel.cardapio.model.prato;

import edu.unicesumar.fravel.cardapio.model.cardapio.Cardapio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Table
@Entity
public class Prato {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

//    @ManyToOne
//    @JoinColumn(name = "cardapio_id", nullable = false)
//    private Cardapio cardapio;

    @Column(nullable = false)
    private BigDecimal valor;
}
