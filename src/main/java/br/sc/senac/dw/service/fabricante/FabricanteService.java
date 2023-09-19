
package br.sc.senac.dw.service.fabricante;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sc.senac.dw.model.entity.fabricante.Fabricante;
import br.sc.senac.dw.model.repository.fabricante.FabricanteRepository;
// import br.sc.senac.dw.seletor.fabricante.FabricanteSeletor;
// import br.sc.senac.dw.specification.fabricante.FabricanteSpecifications;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository FabricanteRepository;

    @Transactional
    public List<Fabricante> listarTodos() {
        return FabricanteRepository.findAll();
    }

    public Fabricante consultarPorID(Long id) {
        return FabricanteRepository.findById(id.longValue()).get();
    }

    public Fabricante inserir(Fabricante novoFabricante) {
        return FabricanteRepository.save(novoFabricante);
    }

    public Fabricante atualizar(Fabricante FabricanteParaAtualizar) {
        return FabricanteRepository.save(FabricanteParaAtualizar);
    }

    public boolean excluir(Integer id) {
        FabricanteRepository.deleteById(id.longValue());
        return true;
    }

    public Fabricante consultarPorId(Integer id) {
        return null;
    }

    // public List<Fabricante> listarComSeletor(FabricanteSeletor seletor) {
    //     Specification<Fabricante> specification = FabricanteSpecifications.comFiltros(seletor);
    //     return FabricanteRepository.findAll(specification);
    // }
}
