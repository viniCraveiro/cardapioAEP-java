package edu.unicesumar.fravel.cardapio.model.prato;

import ch.qos.logback.classic.spi.IThrowableProxy;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PratoService {

    private final PratoRepository pratoRepository;


    public PratoService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    public Prato criar(Prato prato) {
        return pratoRepository.save(prato);
    }

    public Page<Prato> pageable() {
        return pratoRepository.findAll(Pageable.ofSize(20));
    }

    public Prato findById(Long id) {
        return pratoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Prato não encontrado"));
    }

    public void deletaPrato(Long id) {
        pratoRepository.deleteById(id);
    }

    public Prato editaPrato(Long id, Prato pratoEditado) {
        final Prato prato = findById(id);
        if(pratoEditado != null) prato.setNome(pratoEditado.getNome());
        final Prato pratoEditaded = pratoRepository.save(prato);
        return pratoEditaded;
    }
}
