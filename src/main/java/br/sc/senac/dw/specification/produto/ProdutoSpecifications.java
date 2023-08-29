package br.sc.senac.dw.specification.produto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.sc.senac.dw.model.entity.produto.Produto;
import br.sc.senac.dw.seletor.produto.ProdutoSeletor;
import jakarta.persistence.criteria.Predicate;

public class ProdutoSpecifications {

    public static Specification<Produto> comFiltros(ProdutoSeletor seletor) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (seletor.getNome() != null) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
            }

            //TODO #1
            if (seletor.getFabricante() != null) {
                predicates.add(cb.like(cb.lower(root.join("fabricante").get("fabricante")), "%"
                        + seletor.getFabricante().toLowerCase() + "%"));
            }

            if (seletor.getPesoMinimo() != null && seletor.getPesoMaximo() != null) {
                // WHERE peso BETWEEN min AND max
                predicates.add(cb.between(root.get("peso"), seletor.getPesoMinimo(),
                        seletor.getPesoMaximo()));
            } else if (seletor.getPesoMinimo() != null) {
                // WHERE peso >= min
                predicates.add(cb.greaterThanOrEqualTo(root.get("peso"), seletor.getPesoMinimo()));
            } else if (seletor.getPesoMaximo() != null) {
                // WHERE peso <= max
                predicates.add(cb.lessThanOrEqualTo(root.get("peso"), seletor.getPesoMaximo()));
            }

            if (seletor.getValorMinimo() != null && seletor.getValorMaximo() != null) {
                // WHERE valor BETWEEN min AND max
                predicates.add(cb.between(root.get("valor"), seletor.getValorMinimo(),
                        seletor.getValorMaximo()));
            } else if (seletor.getValorMinimo() != null) {
                // WHERE valor >= min
                predicates.add(cb.greaterThanOrEqualTo(root.get("valor"), seletor.getValorMinimo()));
            } else if (seletor.getValorMaximo() != null) {
                // WHERE valor <= max
                predicates.add(cb.lessThanOrEqualTo(root.get("valor"), seletor.getValorMaximo()));
            }

            if (seletor.getDataCadastroInicial() != null && seletor.getDataCadastroFinal() != null) {
                // WHERE data_cadastro BETWEEN min AND max
                predicates.add(cb.between(root.get("data_cadastro"), seletor.getDataCadastroInicial(),
                        seletor.getDataCadastroFinal()));
            } else if (seletor.getDataCadastroInicial() != null) {
                // WHERE data_cadastro >= min
                predicates.add(cb.greaterThanOrEqualTo(root.get("data_cadastro"), seletor.getDataCadastroInicial()));
            } else if (seletor.getDataCadastroFinal() != null) {
                // WHERE data_cadastro <= max
                predicates.add(cb.lessThanOrEqualTo(root.get("data_cadastro"), seletor.getDataCadastroFinal()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
