package br.sc.senac.dw.controller.produto;

// import java.time.LocalDate;
// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.sc.senac.dw.exception.CampoInvalidoException;
import br.sc.senac.dw.model.entity.produto.Produto;
import br.sc.senac.dw.seletor.produto.ProdutoSeletor;
import br.sc.senac.dw.service.produto.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(path = "/todos")
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodos();
    }
    
    
    @GetMapping(path = "/{id}")
    public Produto consultarPorID(@PathVariable Integer id) {
        return produtoService.consultarPorID(id.longValue());
    }

    @PostMapping("/filtro")
	public List<Produto> listarComSeletor(@RequestBody ProdutoSeletor seletor){
		return produtoService.listarComSeletor(seletor);
	}

    @PostMapping
    public Produto salvar(@RequestBody Produto novoProduto) throws CampoInvalidoException {
        return produtoService.inserir(novoProduto);
    }

    @PutMapping
    public boolean atualizar(@RequestBody Produto produtoParaAtualizar) throws CampoInvalidoException {
        return produtoService.atualizar(produtoParaAtualizar) != null;
    }

    @DeleteMapping(path = "/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return produtoService.excluir(id);
    }
}
