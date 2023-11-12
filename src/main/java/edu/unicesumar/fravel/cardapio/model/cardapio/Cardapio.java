package edu.unicesumar.fravel.cardapio.model.cardapio;

import edu.unicesumar.fravel.cardapio.model.prato.Prato;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Cardapio {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @Column
//    @OneToMany(mappedBy = "cardapio", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Prato> pratos;

}
