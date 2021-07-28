package br.com.projetox.v2.service;

import br.com.projetox.v2.error.ResourceNotFoundException;
import br.com.projetox.v2.model.Filme;
import br.com.projetox.v2.model.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FilmeService {

    //utilizando pra injetar a dependência
    FilmeRepository filmeRepository;

    public Filme findById(Long filmeid) {
        return filmeRepository.findById(filmeid).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
    }

    public Filme save(Filme filme) {
        this.filmeRepository.insert(filme);
        return filme;
    }


    public void update(Filme filme) {
        this.filmeRepository.update(filme);
    }


    public void delete(Long filmeId) {
        this.filmeRepository.delete(filmeId);
    }


    public List<Filme> select() {
        List<Filme> filmes = this.filmeRepository.select();
        return filmes;
    }
}