package br.sc.senac.dw.controller.fabricante;

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
import br.sc.senac.dw.model.entity.fabricante.Fabricante;
// import br.sc.senac.dw.seletor.fabricante.FabricanteSeletor;
import br.sc.senac.dw.service.fabricante.FabricanteService;

@RestController
@RequestMapping(path = "/api/fabricantes")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:5500"}, maxAge = 3600)
public class FabricanteController {

    
    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping
    public Fabricante salvar(@RequestBody Fabricante novoFabricante) throws CampoInvalidoException {
        return fabricanteService.inserir(novoFabricante);
    }

    @PutMapping
    public boolean atualizar(@RequestBody Fabricante fabricanteParaAtualizar) throws CampoInvalidoException {
        return fabricanteService.atualizar(fabricanteParaAtualizar) != null;
    }
    
    @GetMapping(path = "/{id}")
    public Fabricante consultarPorId(@PathVariable Integer id){
        return fabricanteService.consultarPorId(id);
    }

    @GetMapping(path = "/todos")
    public List<Fabricante> listarTodosFabricantes() {
        return fabricanteService.listarTodos();
    }

    // @PostMapping("/filtro")
	// public List<Fabricante> listarComSeletor(@RequestBody FabricanteSeletor seletor){
	// 	return fabricanteService.listarComSeletor(seletor);
	// }

    @DeleteMapping(path = "/{id}")
    public boolean excluir(@PathVariable Integer id) {
        return fabricanteService.excluir(id);
    }
}
