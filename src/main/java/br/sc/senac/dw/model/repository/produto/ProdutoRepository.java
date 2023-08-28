package br.sc.senac.dw.model.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import br.sc.senac.dw.model.entity.produto.Produto;

// Repository não precisa de anotação @Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
