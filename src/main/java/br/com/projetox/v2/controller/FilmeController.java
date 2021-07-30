package br.com.projetox.v2.controller;
//ele que disponibiliza os seus serviços por meio de uma api REST

import br.com.projetox.v2.model.Filme;
import br.com.projetox.v2.service.FilmeService;
import br.com.projetox.v2.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/v2/filmes") //informando qual caminho principal da nossa api
@Api(value = "API REST Filmes")
@CrossOrigin(origins = "*") //informando quem pode acessar
public class FilmeController {
    DateUtil dateUtil;
    FilmeService filmeService;

    //Endpoints
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Adiciona um filme")
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Filme save(@RequestBody @Valid Filme filme) { //RequestBody, usando pra informar que está vindo de uma requisição
        return filmeService.save(filme);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Atualiza um filme")
    @PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Filme filme) {
            filmeService.update(filme);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deleta um filme")
    @DeleteMapping(path = "/{filmeId}") //utilizando devido ao valor ser passado diretamente na url
    public void delete(@PathVariable("filmeId") Long filmeId) {
            filmeService.delete(filmeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna uma lista de filmes")
    @GetMapping(path = "/")
    public List<Filme> select() {
            log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now())); //gerando log
            return filmeService.select();
    }

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Retorna um filme único")
    @GetMapping(path = "/{filmeid}") //padrão da url
    public Filme findById(@PathVariable Long filmeid) {
        return filmeService.findById(filmeid);
    }

}
