package br.sc.senac.dw.model.entity.endereco;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.sc.senac.dw.model.entity.fabricante.Fabricante;
// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "endereco")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // private String rua;
    // private String numero;
    // private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    
    @JsonBackReference
    @OneToMany(mappedBy = "endereco")
    private List<Fabricante> fabricantes;
}
