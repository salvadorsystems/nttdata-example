package Grupo6.nttdata.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Data
public class PersonaModel {
	
	@Column(name = "NOMBRES")
	private String nombres;
	
	@Column(name = "GENERO")	
	private String genero;
	
	@Column(name = "TIPO_DOC")	
	private String tipoDoc;
	
	@Column(name = "NUM_DOC")
	private String numDoc;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
}
