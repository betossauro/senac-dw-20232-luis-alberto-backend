package br.sc.senac.dw.model.repository.endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.sc.senac.dw.model.entity.endereco.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>, JpaSpecificationExecutor<Endereco>{

    List<Endereco> findAllByRuaLike(String rua);

    List<Endereco> findAllByNumeroLike(String numero);

    List<Endereco> findAllByBairroLike(String bairro);

    List<Endereco> findAllByCepLike(String cep);

    List<Endereco> findAllByCidadeLike(String cidade);

    List<Endereco> findAllByEstadoLike(String estado);
}
