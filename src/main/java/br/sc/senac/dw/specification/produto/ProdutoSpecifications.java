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

            if (seletor.getNome() != null && !seletor.getNome().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("nome")), "%" + seletor.getNome().toLowerCase() + "%"));
            }

            // String está retornando vazia dando problema no fetch
            if (seletor.getFabricante() != null && !seletor.getFabricante().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.join("fabricante").get("nome")), "%"
                        + seletor.getFabricante().toLowerCase() + "%"));
            }

            if (seletor.getCnpjFabricante() != null  && !seletor.getCnpjFabricante().isEmpty()) {
                predicates.add(cb.equal(root.join("fabricante").get("cnpj"), 
                        seletor.getCnpjFabricante().toLowerCase()));
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
                // WHERE dataCadastro BETWEEN min AND max
                predicates.add(cb.between(root.get("dataCadastro"), seletor.getDataCadastroInicial(),
                        seletor.getDataCadastroFinal()));
            } else if (seletor.getDataCadastroInicial() != null) {
                // WHERE dataCadastro >= min
                predicates.add(cb.greaterThanOrEqualTo(root.get("dataCadastro"), seletor.getDataCadastroInicial()));
            } else if (seletor.getDataCadastroFinal() != null) {
                // WHERE dataCadastro <= max
                predicates.add(cb.lessThanOrEqualTo(root.get("dataCadastro"), seletor.getDataCadastroFinal()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
