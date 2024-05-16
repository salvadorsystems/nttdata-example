package Grupo6.nttdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity(name = "ClienteModel")
@Data
@Table(name = "CLIENTE")
public class ClienteModel extends PersonaModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCliente")
	@SequenceGenerator(sequenceName = "SEQ_CLIENTE", allocationSize =  1, name = "seqCliente")
	@Column(name = "ID_CLIENTE")
	@Builder.Default
	private Long id = 0L;
	
	@Column(name = "CONTRASEÑA")
	private String contraseña;
	
	@Column(name = "ESTADO")
	@Builder.Default
	private String estado = "1";
	
				
}
