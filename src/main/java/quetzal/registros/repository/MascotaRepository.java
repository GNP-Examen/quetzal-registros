package quetzal.registros.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import quetzal.registros.model.MascotaDM;

public interface MascotaRepository extends JpaRepository<MascotaDM, Integer>{
	
	void save(Optional<MascotaDM> mascota);
	
	@Query(value = "SELECT * FROM quetzal.mascota WHERE propietario= :propietario", nativeQuery=true)
	List<MascotaDM> mascotasPorPropietario(String propietario);
	
}
