package Grupo6.nttdata.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO {
	
	private Long id ;
	
	private String nombres;
		
	private String genero;

	private String tipoDoc;
	
	private String numDoc;
	
	private String direccion;
	
	private String telefono;
	
	private String contraseña;
	
	private String estado;
	
}
