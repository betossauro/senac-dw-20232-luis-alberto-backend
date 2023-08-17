package br.sc.senac.dw.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.senac.dw.model.entity.Produto;

// Repository não precisa de anotação @Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
