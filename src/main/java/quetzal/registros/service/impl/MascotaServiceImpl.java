package quetzal.registros.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import quetzal.registros.model.MascotaDM;
import quetzal.registros.model.VisitaDM;
import quetzal.registros.repository.MascotaRepository;
import quetzal.registros.repository.VisitaRepository;
import quetzal.registros.service.MascotaService;
import quetzal.registros.util.GenericRequestObject;

@Service
public class MascotaServiceImpl implements MascotaService {

	private static final Logger LOGGER = LogManager.getLogger(MascotaServiceImpl.class);
	
	private static final String OK = "OK";

	@Autowired
	private MascotaRepository mascotaRepository;
	
	@Autowired
	private VisitaRepository visitaRepository;

	@Override
	public String guardarMascota(GenericRequestObject requestObject) {
		try {
			MascotaDM mascota = new MascotaDM();
			mascota.setNombreMascota((String) requestObject.getPayload().get("nombre"));
			mascota.setRaza((String) requestObject.getPayload().get("raza"));
			mascota.setColor((String) requestObject.getPayload().get("color"));
			mascota.setTamano((String) requestObject.getPayload().get("tamano"));
			mascota.setSexo((String) requestObject.getPayload().get("sexo"));
			mascota.setPropietario((String) requestObject.getPayload().get("propietario"));
			mascota.setEdad(Integer.parseInt((String) requestObject.getPayload().get("edad")));
			mascota = mascotaRepository.save(mascota);
			LOGGER.info("Mascota:" + mascota.toString());
		} catch (Exception e) {
			return "ERROR: " + e.getMessage();
		}
		return OK;
	}

	@Override
	public String guardarVisita(GenericRequestObject requestObject) {
		try {
			final Integer id = Integer.parseInt((String)requestObject.getPayload().get("idMascota"));
			VisitaDM visita = new VisitaDM();
			visita.setDiagnostico((String)requestObject.getPayload().get("diagnostico"));
			visita.setFecha(obtenerFecha((String)requestObject.getPayload().get("fecha")));
			visita.setMotivoVisita((String)requestObject.getPayload().get("motivoVisita"));
			visita.setId_mascota(id);
			visitaRepository.save(visita);
			LOGGER.info("Visita:" + visita.toString());
		} catch (Exception e) {
			return "ERROR: " + e.getMessage();
		}
		return OK;
	}
	
	@Override
	public String actualizarPropietario(GenericRequestObject requestObject) {
		final Integer id = Integer.parseInt((String)requestObject.getPayload().get("idMascota"));
		final String propietario = (String)requestObject.getPayload().get("propietario");
		Optional<MascotaDM> mascota = mascotaRepository.findById(id);
		if(mascota.isPresent()) {
			final MascotaDM mascotaToUpdate = mascota.get();
			mascotaToUpdate.setPropietario(propietario);
			mascotaRepository.save(mascotaToUpdate);	
			return OK;
		}
		return "ERROR : No se pudo actualizar el propietario";
	}
	
	private Date obtenerFecha(String fecha) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
	}

	@Override
	public List<MascotaDM> buscarMascotaOrdenada(GenericRequestObject requestObject) {
		final String campo = (String)requestObject.getPayload().get("campo");
		final String sort = (String)requestObject.getPayload().get("sort");
		List<MascotaDM> mascotas = mascotaRepository.findAll(Sort.by(Sort.Direction.valueOf(sort), campo));
		LOGGER.info(mascotas);
		return mascotas;
	}

	@Override
	public List<MascotaDM> buscarMascotas() {
		return mascotaRepository.findAll();
	}

	@Override
	public List<MascotaDM> buscarMascotasPorPropietario(String propietario) {
		return mascotaRepository.mascotasPorPropietario(propietario);
	}

}
