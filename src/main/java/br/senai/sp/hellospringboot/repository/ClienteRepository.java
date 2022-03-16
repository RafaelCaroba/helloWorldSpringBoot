package br.senai.sp.hellospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.senai.sp.hellospringboot.model.Cliente;

// crud repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	public Cliente findByCpf(String cpf); // nome do métoo tem que ser findBy
	
	// select * from cliente where nome like '%{nome}%'
	public List<Cliente> findByNomeLike(String nome);
	
	@Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:n%") // c = variavel do objeto  // n = parâmetro; substituirá o param 'nome' do método
	public List<Cliente> procurarPeloNome(@Param("n") String nome);
	
	@Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:p% OR c.cpf LIKE %:p% OR c.email LIKE %:p%")
	public List<Cliente> procurarTudo(@Param("p") String param);
}


