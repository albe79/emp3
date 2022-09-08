package com.mision3.empresa.Repositorio;

import com.mision3.empresa.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface repoempleado extends JpaRepository<Empleado,Long> {
    @Override
    List<Empleado> findAll();
    boolean existsById(Long id);

    @Override
    Optional<Empleado> findById(Long id);
}
