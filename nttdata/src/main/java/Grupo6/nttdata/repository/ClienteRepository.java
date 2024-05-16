package Grupo6.nttdata.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Grupo6.nttdata.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long>{
	
	Optional<ClienteModel> findByNumDoc(String docIdentif);

}
