package com.ibm.aula2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.aula2.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
	List<UsuarioEntity>findUsuarioEntityByNomeContaining(String nome);//encontrar por nome
	List<UsuarioEntity>deleteById(Integer id);
}
