package com.example.ServidorVehiculoSura6.controladores;

import com.example.ServidorVehiculoSura6.modelos.Usuario;
import com.example.ServidorVehiculoSura6.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuario")
public class ControladorUsuario {

    //Inyectamos el servicio
    @Autowired
    UsuarioServicio usuarioServicio;

    //Llamamos al método que guarda
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Usuario datos) throws Exception{
        //el signo de ? representa que no sé que devuelvo, pero responde
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.guardarUsuario((datos)));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    //Llamamos al método que busca
    @GetMapping
    public ResponseEntity<?>buscar() throws Exception{
        try{
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.buscarUsuarios());
        }
        catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }

    }
}

