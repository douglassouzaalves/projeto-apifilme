package br.com.projetox.controller;
//ele que disponibiliza seus serviços por meio de uma api REST

import br.com.projetox.model.Filme;
import br.com.projetox.service.FilmeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController //anotação que add o @Controller e @ResponseBody
@RequestMapping("filmes") //utilizando para implementar a url
public class FilmeController {

    FilmeService filmeService;

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE) //ResponseEntity representando a resposta http
    public ResponseEntity<?> save(@RequestBody @Valid Filme filme) {
        try {
            filmeService.save(filme);           //passando status e corpo da resposta
            return ResponseEntity.status(HttpStatus.CREATED).body(filme); //compoem a resposta http
            //não utilizar responseEntity
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar");
        }
    }

    @PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Filme filme) {
        try {
            filmeService.update(filme);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(filme);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar");
        }
    }

    @DeleteMapping(path = "/{filmeId}") //utilizando devido ao valor ser passado diretamente na url
    public ResponseEntity<?> delete(@PathVariable("filmeId") Long filmeId) {
        try {
            filmeService.delete(filmeId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar");
        }
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> select() {
        try {
            List<Filme> filmes = filmeService.select();
            return ResponseEntity.status(HttpStatus.OK).body(filmes);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao selecionar");
        }
    }
}
