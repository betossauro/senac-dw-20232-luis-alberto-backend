package br.sc.senac.dw.controller;

// import java.time.LocalDate;
// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.model.entity.Produto;
import br.sc.senac.dw.service.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos")
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
}
