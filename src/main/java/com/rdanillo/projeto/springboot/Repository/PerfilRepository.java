package com.rdanillo.projeto.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rdanillo.projeto.springboot.domain.Perfil;

//@Repository
@RepositoryRestResource(collectionResourceRel = "perfil",path = "perfil")
public interface PerfilRepository  extends JpaRepository<Perfil, Long>{

}
