package com.example.ServidorVehiculoSura6.repositorios;

import com.example.ServidorVehiculoSura6.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
