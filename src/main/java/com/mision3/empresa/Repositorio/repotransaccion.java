package com.mision3.empresa.Repositorio;

import com.mision3.empresa.Entidades.Empleado;
import com.mision3.empresa.Entidades.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface repotransaccion extends JpaRepository<Transaccion,Long> {
    @Override
    List<Transaccion> findAll();
    boolean existsById(Long id);

    @Override
    Optional<Transaccion> findById(Long id);
}
