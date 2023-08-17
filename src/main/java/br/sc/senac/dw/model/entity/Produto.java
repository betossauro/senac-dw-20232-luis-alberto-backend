package br.sc.senac.dw.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {

    @Id
    private Integer id;
    private String nome;
    private String fabricante;
    private Double valor;
    private Double peso;
    @Column(name = "data_cadastro")
    private LocalDate data;
}
