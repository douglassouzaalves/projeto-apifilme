package br.com.projetox.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class Filme {

    @NotNull(message = "Campo não pode receber nulo")
    private Long filmeid;
    private String titulo;
    private String oscar;
    private String produtor;
    private Integer estreia;
    private String produtora;

}
