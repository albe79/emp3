package com.mision3.empresa.Repositorio;

import com.mision3.empresa.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repoempleado extends JpaRepository<Empleado,Long> {


}
