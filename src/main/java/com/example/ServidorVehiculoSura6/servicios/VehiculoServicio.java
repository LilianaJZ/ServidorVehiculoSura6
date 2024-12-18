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
    // 4. Actualizar datos de un vehículo
    public Optional<Vehiculo> actualizarVehiculo(Long id, Vehiculo datosActualizados) throws Exception {
        try {
            return iVehiculoRepositorio.findById(id)
                    .map(vehiculo -> {
                        vehiculo.setCilindraje(datosActualizados.getCilindraje());
                        vehiculo.setColor(datosActualizados.getColor());
                        vehiculo.setMarca(datosActualizados.getMarca());
                        vehiculo.setModelo(datosActualizados.getModelo());
                        vehiculo.setSiniestros(datosActualizados.getSiniestros());
                        vehiculo.setPlaca(datosActualizados.getPlaca());
                        vehiculo.setDescripcion(datosActualizados.getDescripcion());
                        vehiculo.setPoliza(datosActualizados.getPoliza());
                        vehiculo.setActivo(datosActualizados.getActivo());
                        return iVehiculoRepositorio.save(vehiculo);
                    });
        } catch (Exception error) {
            throw new Exception("Error al actualizar vehículo: " + error.getMessage());
        }
    }

    // 5. Soft delete (pasar de activo a inactivo)
    public Optional<String> desactivarVehiculo(Long id) throws Exception {
        try {
            return iVehiculoRepositorio.findById(id)
                    .map(vehiculo -> {
                        vehiculo.setActivo(false); // Cambiar el estado a inactivo
                        iVehiculoRepositorio.save(vehiculo);
                        return Optional.of("Vehículo desactivado correctamente");
                    })
                    .orElseThrow(() -> new Exception("Vehículo no encontrado"));
        } catch (Exception error) {
            throw new Exception("Error al desactivar vehículo: " + error.getMessage());
        }
    }

    // 6. Eliminar un vehículo permanentemente
    public Optional<String> eliminarVehiculo(Long id) throws Exception {
        try {
            return iVehiculoRepositorio.findById(id)
                    .map(vehiculo -> {
                        iVehiculoRepositorio.deleteById(id);
                        return Optional.of("Vehículo eliminado permanentemente");
                    })
                    .orElseThrow(() -> new Exception("Vehículo no encontrado"));
        } catch (Exception error) {
            throw new Exception("Error al eliminar vehículo: " + error.getMessage());
        }
    }

}
