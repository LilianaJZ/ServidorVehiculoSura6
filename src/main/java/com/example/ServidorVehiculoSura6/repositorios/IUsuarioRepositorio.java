package com.example.ServidorVehiculoSura6.repositorios;

import com.example.ServidorVehiculoSura6.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {



}
