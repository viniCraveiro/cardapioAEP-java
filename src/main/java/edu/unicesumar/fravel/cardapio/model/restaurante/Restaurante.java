package edu.unicesumar.fravel.cardapio.model.restaurante;

import edu.unicesumar.fravel.cardapio.model.cardapio.Cardapio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Restaurante {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50)
    private String nome;

//    @ManyToMany
//    @JoinTable(
//            name = "restaurante_cardapio",
//            joinColumns = @JoinColumn(name = "restaurante_id"),
//            inverseJoinColumns = @JoinColumn(name = "cardapio_id")
//    )
//    private List<Cardapio> cardapio;
}
