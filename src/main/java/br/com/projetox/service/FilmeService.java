package br.com.projetox.service;

import br.com.projetox.model.Filme;
import br.com.projetox.model.FilmeMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FilmeService {

    //utilizando pra injetar a dependência
    FilmeMapper mapper;


    public void save(Filme filme) {
        this.mapper.insert(filme);
    }


    public void update(Filme filme) {
        this.mapper.update(filme);
    }


    public void delete(Long filmeId) {
        this.mapper.delete(filmeId);
    }


    public List<Filme> select() {
        List<Filme> filmes = this.mapper.select();
        return filmes;
    }
}