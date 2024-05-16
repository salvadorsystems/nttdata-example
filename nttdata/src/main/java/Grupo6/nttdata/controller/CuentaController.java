package Grupo6.nttdata.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Grupo6.nttdata.model.ClienteModel;
import Grupo6.nttdata.model.CuentaModel;
import Grupo6.nttdata.service.impl.CuentaService;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {
	
	@Autowired
	CuentaService cuentaService;
	
	@Autowired
	ClienteController clienteController;
	
	@PostMapping("/{docIdenti}")
	public ResponseEntity<CuentaModel> crearCuenta(@RequestBody CuentaModel cuenta ,@PathVariable("docIdenti") String docIdenti) {
									
		cuentaService.createCuenta(cuenta, docIdenti);
		return new ResponseEntity<CuentaModel>(HttpStatus.CREATED);
	}


}
