package org.generation.projetointegrador.repository;

import java.util.Optional;

import org.generation.projetointegrador.model.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosModel, Long> {
	
	public Optional<UsuariosModel> findByUsuario(String usuario);

}
