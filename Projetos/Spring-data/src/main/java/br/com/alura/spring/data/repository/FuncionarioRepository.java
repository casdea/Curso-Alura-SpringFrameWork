package br.com.alura.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>  {

	List<Funcionario> findByNomeFuncionario(String nomeFuncionario);
	
	List<Funcionario> findByCargoDescricao(String descricao);
	
	@Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
	List<Funcionario> findByCargoDescricaoQuery(String descricao);
	
}
