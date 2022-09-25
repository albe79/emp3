package com.mision3.empresa.Repositorio;


import com.mision3.empresa.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface repousuario extends JpaRepository<Usuario,Long> {
   Usuario findByEmail(String email);
}
