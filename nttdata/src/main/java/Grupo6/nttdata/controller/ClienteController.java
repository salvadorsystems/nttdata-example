package Grupo6.nttdata.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Grupo6.nttdata.dto.ClienteDTO;
import Grupo6.nttdata.model.ClienteModel;
import Grupo6.nttdata.service.OperacionCRUD;
import Grupo6.nttdata.service.impl.ClienteService;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	OperacionCRUD op;
	
	@PostMapping
	public ClienteDTO crear(@RequestBody ClienteDTO cliente, BindingResult result){
						
		return clienteService.create(cliente);
	}
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<?>> leer(){
		
		List<?> listado = op.read();
		
		return new ResponseEntity<List<?>>(listado, HttpStatus.OK);
	}
	
	@GetMapping("/{docIdenti}")
	public ResponseEntity<Optional<?>> leerByNumDoc(@PathVariable("docIdenti") String docIdenti){
		
		
		Optional<?> cliente = clienteService.readBynumDoc(docIdenti);				
		
		return new ResponseEntity<Optional<?>>(cliente, HttpStatus.OK);
	}

}
