package com.mision3.empresa.Repositorio;

import com.mision3.empresa.Entidades.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repotransaccion extends JpaRepository<Transaccion,Long> {

}
