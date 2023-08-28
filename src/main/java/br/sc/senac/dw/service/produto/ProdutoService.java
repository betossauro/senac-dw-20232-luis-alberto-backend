package br.sc.senac.dw.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sc.senac.dw.model.entity.produto.Produto;
import br.sc.senac.dw.model.repository.produto.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto consultarPorID(Long id) {
        return produtoRepository.findById(id.longValue()).get();
    }

    public Produto inserir(Produto novoProduto) {
        return produtoRepository.save(novoProduto);
    }

    public Produto atualizar(Produto produtoParaAtualizar) {
        return produtoRepository.save(produtoParaAtualizar);
    }

    public boolean excluir(Integer id) {
        produtoRepository.deleteById(id.longValue());
        return true;
    }
}
