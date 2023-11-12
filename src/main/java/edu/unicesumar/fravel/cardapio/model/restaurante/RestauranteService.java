package edu.unicesumar.fravel.cardapio.model.restaurante;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;


    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public Restaurante criarEstabelecimento(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }


    public Restaurante criar(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public Page<Restaurante> pageable() {
        return restauranteRepository.findAll(Pageable.ofSize(20));
    }

    public Restaurante findById(Long id) {
        return restauranteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Restaurante não encontrado"));
    }

    public void deletaRestaurante(Long id) {
        restauranteRepository.deleteById(id);
    }

    public Restaurante editaRestaurante(Long id, Restaurante restauranteEditado) {
        final Restaurante restaurante = findById(id);
        if (restauranteEditado.getNome() != null) restaurante.setNome(restauranteEditado.getNome());

        final Restaurante restauranteEditaded = restauranteRepository.save(restaurante);
        return restauranteEditaded;
    }

}
