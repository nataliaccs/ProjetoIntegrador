package org.generation.projetointegrador.repository;

import java.util.List;

import org.generation.projetointegrador.model.SubtemasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtemasRepository extends JpaRepository<SubtemasModel, Long>{

	public List<SubtemasModel> findAllByDescricaoContainingIgnoreCase (@Param("descricao")String descricao);
}
