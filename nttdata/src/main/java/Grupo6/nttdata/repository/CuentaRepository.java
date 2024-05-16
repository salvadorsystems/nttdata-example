package Grupo6.nttdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Grupo6.nttdata.model.CuentaModel;

public interface CuentaRepository extends JpaRepository<CuentaModel, Long>{

	CuentaModel findByNumCuenta(String numCuenta);
}
