package br.com.projetox.v2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    private Long filmeid;
    private String titulo;
    private String oscar;
    private String produtor;
    private Integer estreia;
    private String produtora;


}
