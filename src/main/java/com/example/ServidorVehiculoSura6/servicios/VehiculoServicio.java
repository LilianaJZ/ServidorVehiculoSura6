package com.example.ServidorVehiculoSura6.servicios;

import com.example.ServidorVehiculoSura6.modelos.Vehiculo;
import com.example.ServidorVehiculoSura6.repositorios.IVehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServicio {

    @Autowired
    IVehiculoRepositorio iVehiculoRepositorio;

    //Se crean métodos para definir las operaciones a realizar en la base de datos.
    //1. Registrar o guardar un Vehiculo.
    public Vehiculo guardarVehiculo(Vehiculo datosVehiculo) throws Exception {
        try {
            return iVehiculoRepositorio.save(datosVehiculo);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //2. Buscar todos los vehiculos.
    public List<Vehiculo> buscarVehiculos()throws Exception {
        //es una lista porque puede devolver varios vehiculos
        try{
            return iVehiculoRepositorio.findAll();
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //3.Buscar un solo vehiculo
    public Vehiculo buscarVehiculoPorId(Long id) throws Exception{
        try{
            Optional<Vehiculo> vehiculoEncontrado=iVehiculoRepositorio.findById(id);
            //hay que castear
            if(vehiculoEncontrado.isPresent()){
                return vehiculoEncontrado.get();
            }else{
                throw new Exception("vehiculo no encontrado");
            }
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }
}
