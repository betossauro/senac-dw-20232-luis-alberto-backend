package br.sc.senac.dw.controller.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.exception.CampoInvalidoException;
import br.sc.senac.dw.model.entity.endereco.Endereco;
import br.sc.senac.dw.seletor.endereco.EnderecoSeletor;
import br.sc.senac.dw.service.endereco.EnderecoService;

@RestController
@RequestMapping(path = "/api/endereco")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco salvar(@RequestBody Endereco novoEndereco) throws CampoInvalidoException {
        return enderecoService.inserir(novoEndereco);
    }

    @PutMapping
    public boolean atualizar(@RequestBody Endereco enderecoParaAtualizar) throws CampoInvalidoException {
        return enderecoService.atualizar(enderecoParaAtualizar) != null;
    }
    
    @GetMapping(path = "/{id}")
    public Endereco consultarPorId(@PathVariable Integer id){
        return enderecoService.consultarPorId(id);
    }

    @GetMapping(path = "/todos")
    public List<Endereco> listarTodosEnderecos() {
        return enderecoService.listarTodos();
    }

    @PostMapping("/filtro")
	public List<Endereco> listarComSeletor(@RequestBody EnderecoSeletor seletor){
		return enderecoService.listarComSeletor(seletor);
	}

    @DeleteMapping(path = "/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return enderecoService.excluir(id);
    }
}
