package quetzal.registros.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import quetzal.registros.model.MascotaDM;
import quetzal.registros.service.MascotaService;
import quetzal.registros.util.GenericRequestObject;
import quetzal.registros.util.ResponseApi;

@RestController
@RequestMapping(path = "quetzal/")
public class MascotaController {

	private static final Logger LOGGER = LogManager.getLogger(MascotaController.class);
	private static final String OK = "OK";

	@Autowired
	private MascotaService mascotaService;

	@PostMapping(path = "/guardarMascota", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> agregarMascota(@RequestHeader Map<String, String> headersReq,
			@RequestBody GenericRequestObject request) {
		LOGGER.info("*** Agregando nueva mascota ***");
		ResponseApi<String> response = null;
		String responseStr = mascotaService.guardarMascota(request);
		if (OK.equals(responseStr)) {
			response = new ResponseApi<String>("Registro Exitoso", HttpStatus.OK.name(), responseStr);
		} else {
			response = new ResponseApi<String>("Error", HttpStatus.BAD_REQUEST.name(), responseStr);
		}
		LOGGER.info("*** Terminando registro mascota***");
		return ResponseEntity.ok().body(response);
	}

	@PatchMapping(path = "/actualizarPropietario", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> actualizarPropietario(@RequestHeader Map<String, String> headersReq,
			@RequestBody GenericRequestObject request) {
		LOGGER.info("*** Actualizando Propietario ***");
		ResponseApi<String> response = null;
		String responseStr = mascotaService.actualizarPropietario(request);
		if (OK.equals(responseStr)) {
			response = new ResponseApi<String>("Registro Exitoso", HttpStatus.OK.name(), responseStr);
		} else {
			response = new ResponseApi<String>("Error", HttpStatus.BAD_REQUEST.name(), responseStr);
		}
		LOGGER.info("*** Terminando Actualizacion***");
		return ResponseEntity.ok().body(response);
	}

	@GetMapping(path = "/buscarMascotasPropietario/{propietario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> obtenerMascotasPropietario(@RequestHeader Map<String, String> headersReq,
			@PathVariable("propietario") String propietario) {
		LOGGER.info("*** Obteniendo todas las mascotas por propietario : {}",propietario);
		ResponseApi<Map<String, Object>> response = null;
		Map<String, Object> prospectosMap = new HashMap<String, Object>();
		List<MascotaDM> mascotas = mascotaService.buscarMascotasPorPropietario(propietario);
		prospectosMap.put("mascotas", mascotas);
		if (!mascotas.isEmpty()) {
			response = new ResponseApi<Map<String, Object>>("Busqueda Exitosa", HttpStatus.OK.name(), prospectosMap);
		} else {
			response = new ResponseApi<Map<String, Object>>("Error", HttpStatus.BAD_REQUEST.name(), prospectosMap);
		}
		LOGGER.info("*** Terminando Busqueda ***");
		return ResponseEntity.ok().body(response);
	}

	@GetMapping(path = "/buscarMascotas", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> obtenerTodasMascotas(@RequestHeader Map<String, String> headersReq) {
		LOGGER.info("*** Obteniendo todas las mascotas ***");
		ResponseApi<Map<String, Object>> response = null;
		Map<String, Object> prospectosMap = new HashMap<String, Object>();
		List<MascotaDM> mascotas = mascotaService.buscarMascotas();
		prospectosMap.put("mascotas", mascotas);
		if (!mascotas.isEmpty()) {
			response = new ResponseApi<Map<String, Object>>("Busqueda Exitosa", HttpStatus.OK.name(), prospectosMap);
		} else {
			response = new ResponseApi<Map<String, Object>>("Error", HttpStatus.BAD_REQUEST.name(), prospectosMap);
		}
		LOGGER.info("*** Terminando Busqueda ***");
		return ResponseEntity.ok().body(response);
	}

	@PostMapping(path = "/guardarVisita", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> agregarVisita(@RequestHeader Map<String, String> headersReq,
			@RequestBody GenericRequestObject request) {
		LOGGER.info("*** Agregando nueva visita ***");
		ResponseApi<String> response = null;
		String responseStr = mascotaService.guardarVisita(request);
		if (OK.equals(responseStr)) {
			response = new ResponseApi<String>("Registro Exitoso", HttpStatus.OK.name(), responseStr);
		} else {
			response = new ResponseApi<String>("Error", HttpStatus.BAD_REQUEST.name(), responseStr);
		}
		LOGGER.info("*** Terminando registro visita ***");
		return ResponseEntity.ok().body(response);
	}

}
