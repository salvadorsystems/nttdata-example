package Grupo6.nttdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity(name = "CuentaModel")
@Data
@Table(name = "CUENTA")
public class CuentaModel {
	
	@Id
	@Column(name = "ID_CUENTA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCuenta")
	@SequenceGenerator(sequenceName = "SEQ_CUENTA", allocationSize = 1, name = "seqCuenta")
	@Builder.Default
	private Long id = 0L;

	@Column(name = "NUM_CUENTA")
	private String numCuenta;

	@Column(name = "TIP_CUENTA")
	private String tipCuenta;

	
	@Column(name = "SALDO_INIT")
	private double saldoInit;

	@Column(name = "ESTADO")
	@Builder.Default
	private String estado = "1";

	@ManyToOne
	@JoinColumn(name = "ID_CLIENTE", nullable = false)
	private ClienteModel clienteModel;

}
