package br.sc.senac.dw.service.endereco;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sc.senac.dw.model.entity.endereco.Endereco;
import br.sc.senac.dw.model.repository.endereco.EnderecoRepository;
import br.sc.senac.dw.seletor.endereco.EnderecoSeletor;
import br.sc.senac.dw.specification.endereco.EnderecoSpecifications;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco inserir(Endereco novoEndereco){
        return enderecoRepository.save(novoEndereco);
    }

    public Endereco atualizar(Endereco enderecoParaAtualizar){
        return enderecoRepository.save(enderecoParaAtualizar);
    }

    public Endereco consultarPorId(Integer id) {
        return enderecoRepository.findById(id).get();
    }

    @Transactional
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    public List<Endereco> listarComSeletor(EnderecoSeletor seletor) {
        Specification<Endereco> specification = EnderecoSpecifications.comFiltros(seletor);
        return enderecoRepository.findAll(specification);
    }

    public boolean excluir(Integer id){
        enderecoRepository.deleteById(id);
        return true;
    }
}
