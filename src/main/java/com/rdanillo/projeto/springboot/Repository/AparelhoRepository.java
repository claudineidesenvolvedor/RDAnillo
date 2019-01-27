package com.rdanillo.projeto.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rdanillo.projeto.springboot.domain.Aparelho;

@Repository
public interface AparelhoRepository  extends JpaRepository<Aparelho, Long>{

}
