package br.com.projetox.v2.controller;
//ele que disponibiliza seus serviços por meio de uma api REST

import br.com.projetox.v2.model.Filme;
import br.com.projetox.v2.service.FilmeService;
import br.com.projetox.v2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController //Controlador que será acessado atráves de uma api rest
@RequestMapping("v2/filmes") //informando qual caminho principal da nossa api
public class FilmeController {
    DateUtil dateUtil;
    FilmeService filmeService;

    //Endpoints
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Filme save(@RequestBody @Valid Filme filme) { //RequestBody, usando pra informar que está vindo de uma requisição
        return filmeService.save(filme);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Filme filme) {
            filmeService.update(filme);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{filmeId}") //utilizando devido ao valor ser passado diretamente na url
    public void delete(@PathVariable("filmeId") Long filmeId) {
            filmeService.delete(filmeId);
    }
    //Toda requisição de página acessamos atŕaves da operação get
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/")
    public List<Filme> select() {
            log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now())); //gerando log
            return filmeService.select();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/{filmeid}") //padrão da url
    public Filme findById(@PathVariable Long filmeid) {
        return filmeService.findById(filmeid);
    }

}
