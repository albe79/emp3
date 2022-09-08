package com.mision3.empresa.Repositorio;

import com.mision3.empresa.Entidades.Empleado;
import com.mision3.empresa.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface repoempresa extends JpaRepository<Empresa,Long> {
    @Override
    List<Empresa> findAll();
    boolean existsById(Long id);

    @Override
    Optional<Empresa> findById(Long id);
}
