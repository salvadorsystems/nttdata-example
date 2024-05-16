package Grupo6.nttdata.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Grupo6.nttdata.dto.ClienteDTO;
import Grupo6.nttdata.model.ClienteModel;
import Grupo6.nttdata.repository.ClienteRepository;
import Grupo6.nttdata.service.OperacionCRUD;

@Service
public class ClienteService implements OperacionCRUD{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<?> read() {
		
		List<ClienteModel> read = clienteRepository.findAll();
		
		// TODO Auto-generated method stub
		return read;
	}
	
	
	public Optional<ClienteModel> readByID(Long id) {
		
		Optional<ClienteModel> read = clienteRepository.findById(id);
		
		// TODO Auto-generated method stub
		return read;
	}
		
	public Optional<ClienteModel>  readBynumDoc(String numDoc) {
		
		Optional<ClienteModel> read = clienteRepository.findByNumDoc(numDoc);
		
		// TODO Auto-generated method stub
		return read;
	}


	
	public ClienteDTO create(ClienteDTO clienteDto) {
		
		ClienteModel clienteModel = conversionDTOMODEL(clienteDto);
					
		clienteRepository.save(clienteModel);
		
		// TODO Auto-generated method stub
		return clienteDto;
	}


	private ClienteModel conversionDTOMODEL(ClienteDTO clienteDto) {
		// TODO Auto-generated method stub
		ClienteModel clienteModel = new ClienteModel();
		
		clienteModel.setId(clienteDto.getId());
		clienteModel.setContraseña(clienteDto.getContraseña());
		clienteModel.setDireccion(clienteDto.getDireccion());
		clienteModel.setEstado(clienteDto.getEstado().equalsIgnoreCase("true")? "1":"0");
		clienteModel.setNombres(clienteDto.getNombres());
		clienteModel.setTelefono(clienteDto.getTelefono());
		clienteModel.setTipoDoc(clienteDto.getTipoDoc());
		clienteModel.setNumDoc(clienteDto.getNumDoc());
		clienteModel.setGenero(clienteDto.getGenero());
				
		return clienteModel;
	}

}
