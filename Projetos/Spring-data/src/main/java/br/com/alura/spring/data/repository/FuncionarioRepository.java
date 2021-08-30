package br.com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecaoClasseDto;
import br.com.alura.spring.data.orm.FuncionarioProjecaoInterface;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>,
	JpaSpecificationExecutor<Funcionario>{

	List<Funcionario> findByNomeFuncionario(String nomeFuncionario);
	
	List<Funcionario> findByCargoDescricao(String descricao);
	
	@Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
	List<Funcionario> findByCargoDescricaoQuery(String descricao);

	@Query("SELECT f FROM Funcionario f WHERE f.nomeFuncionario =:nomeFuncionario "
			+ "AND f.salario>= :salario "
			+ "AND f.dataContratacao =:dataContratacao")
	List<Funcionario> findByNomeSalarioMaiorDataContratacaoQuery(String nomeFuncionario, Double salario, LocalDate dataContratacao);

	@Query(value = "SELECT f.* FROM funcionarios f WHERE f.data_contratacao =:dataContratacao", nativeQuery =  true)
	List<Funcionario> findByDataContratacaoNative(LocalDate dataContratacao);

	@Query(value = "SELECT f.id, f.nome_funcionario, f.salario FROM funcionarios f", nativeQuery =  true)
	List<FuncionarioProjecaoInterface> findBySalarioNativeProjecaoInterface();

	@Query(value = "SELECT f.id, f.nome_funcionario, f.salario FROM funcionarios f", nativeQuery =  true)
	List<FuncionarioProjecaoClasseDto> findBySalarioNativeProjecaoClasseDto();

}
