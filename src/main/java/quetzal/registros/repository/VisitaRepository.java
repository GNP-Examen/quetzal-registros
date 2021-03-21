package quetzal.registros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import quetzal.registros.model.VisitaDM;

public interface VisitaRepository extends JpaRepository<VisitaDM, Integer>{

}
