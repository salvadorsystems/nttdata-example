package Grupo6.nttdata.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Grupo6.nttdata.model.ClienteModel;
import Grupo6.nttdata.model.CuentaModel;
import Grupo6.nttdata.repository.ClienteRepository;
import Grupo6.nttdata.repository.CuentaRepository;

@Service
public class CuentaService {
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	public CuentaModel createCuenta(CuentaModel cuenta, String docIdenti) {
		// TODO Auto-generated method stub		
		
		Optional<ClienteModel> cliente = clienteRepository.findByNumDoc(docIdenti);
		
		cuenta.setClienteModel(cliente.get());
		return cuentaRepository.saveAndFlush(cuenta);
	}
	
	public CuentaModel findByNumDoc(CuentaModel cuenta, String docIdenti) {
		// TODO Auto-generated method stub		
		
		Optional<ClienteModel> cliente = clienteRepository.findByNumDoc(docIdenti);
		
		cuenta.setClienteModel(cliente.get());
		return cuentaRepository.saveAndFlush(cuenta);
	}
	

}
