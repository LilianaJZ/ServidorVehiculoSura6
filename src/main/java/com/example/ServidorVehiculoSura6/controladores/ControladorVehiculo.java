package com.example.ServidorVehiculoSura6.controladores;

import com.example.ServidorVehiculoSura6.modelos.Vehiculo;
import com.example.ServidorVehiculoSura6.servicios.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/vehiculo")
public class ControladorVehiculo {

    @Autowired
    VehiculoServicio vehiculoServicio;

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Vehiculo datos) throws Exception{
        //el signo de ? representa que no sé que devuelvo, pero responde
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vehiculoServicio.guardarVehiculo((datos)));
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
                    .body(vehiculoServicio.buscarVehiculos());
        }
        catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id){
        try{
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(vehiculoServicio.buscarVehiculoPorId(id));
        }
        catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}