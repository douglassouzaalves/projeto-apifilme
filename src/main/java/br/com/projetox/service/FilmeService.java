package br.com.projetox.service;

import br.com.projetox.model.Filme;
import br.com.projetox.model.FilmeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FilmeService {

    //utilizando pra injetar a dependência
    FilmeRepository filmeRepository;


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