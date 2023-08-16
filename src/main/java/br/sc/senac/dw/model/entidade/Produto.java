package br.sc.senac.dw.model.entidade;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Produto {
    private String nome;
    private String fabricante;
    private int valor;
    private int peso;
    private LocalDate data;
    
}
