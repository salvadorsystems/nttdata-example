package Grupo6.nttdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Grupo6.nttdata.model.MovimientoModel;
import Grupo6.nttdata.service.impl.MovimientoService;


@RestController
@RequestMapping("/movimientos")
public class MovimentoController {
	
	@Autowired
	MovimientoService movimientoService;
	
	@PostMapping
	public ResponseEntity<MovimientoModel> crearMovimiento(@RequestBody MovimientoModel movimiento) {
		movimientoService.createMovimiento(movimiento);
		return new ResponseEntity<MovimientoModel>(HttpStatus.CREATED);
	}

}
