package quetzal.registros.service;

import java.util.List;

import quetzal.registros.model.MascotaDM;
import quetzal.registros.util.GenericRequestObject;

public interface MascotaService {
	
	String actualizarPropietario(GenericRequestObject requestObject);
	
	String guardarMascota(GenericRequestObject requestObject);
	
	String guardarVisita(GenericRequestObject requestObject);
	
	List<MascotaDM> buscarMascotaOrdenada(GenericRequestObject requestObject);
	
	List<MascotaDM> buscarMascotas();
	
	List<MascotaDM> buscarMascotasPorPropietario(String propietario);

}
