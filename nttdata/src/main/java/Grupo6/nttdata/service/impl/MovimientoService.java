package Grupo6.nttdata.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Grupo6.nttdata.model.CuentaModel;
import Grupo6.nttdata.model.MovimientoModel;
import Grupo6.nttdata.repository.CuentaRepository;
import Grupo6.nttdata.repository.MovimentoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovimientoService {
	
	double contadorLimite = 0;
	List<String> cuentas = new ArrayList<>();
	
	@Autowired
	private MovimentoRepository movimentoRepository;
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	public MovimientoModel createMovimiento(MovimientoModel movimiento) {
		
		MovimientoModel movimientoModel = movimiento;
		CuentaModel cuentaModel = movimientoModel.getCuentaModel();
		
		CuentaModel cuentaModelIF = cuentaRepository.findByNumCuenta(cuentaModel.getNumCuenta());
		
		double valorLimite = 1000;

		cuentas.add(cuentaModel.getNumCuenta());

		if (!movimientoModel.getTipMov().equalsIgnoreCase("Deposito")) {
			contadorLimite += movimientoModel.getValor();
			for (String string : cuentas) {
				if (!string.equalsIgnoreCase(cuentaModel.getNumCuenta())) {
					contadorLimite = 0;
					cuentas = new ArrayList<>();
				}
			}
		}

		if (!movimientoModel.getTipMov().equalsIgnoreCase("Deposito") && contadorLimite > valorLimite) {
			log.info("Cupo Diario Exedido. [{}]",valorLimite);
			throw new ServiceException("Cupo Diario Exedido.");
		}

		if (!movimientoModel.getTipMov().equalsIgnoreCase("Deposito")
				&& cuentaModelIF.getSaldoInit() < movimientoModel.getValor()) {
			log.info("Saldo no Disponible. [{}]",movimientoModel.getValor());
			throw new ServiceException("Saldo no Disponible.");
		}

		movimientoModel.setSaldoDisponible(cuentaModelIF.getSaldoInit());
		cuentaModelIF.setSaldoInit(movimientoModel.getTipMov().equalsIgnoreCase("Deposito")
				? movimientoModel.getSaldoDisponible() + movimientoModel.getValor()
				: movimientoModel.getSaldoDisponible() - movimientoModel.getValor());
		cuentaRepository.saveAndFlush(cuentaModelIF);
		
		movimientoModel.setCuentaModel(cuentaModelIF);

		return movimentoRepository.save(movimientoModel);
				
	}

}
