package com.mision3.empresa.Repositorio;

import com.mision3.empresa.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface repoempresa extends JpaRepository<Empresa,Long> {

}
