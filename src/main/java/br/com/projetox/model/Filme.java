package br.com.projetox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    //@NotNull(message = "Campo não pode receber nulo")
    private Long filmeid;
    private String titulo;
    private String oscar;
    private String produtor;
    private Integer estreia;
    private String produtora;

}
