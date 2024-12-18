package com.example.ServidorVehiculoSura6.servicios;

import com.example.ServidorVehiculoSura6.modelos.Usuario;
import com.example.ServidorVehiculoSura6.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    //Llamando al repositorio de usuario.
    @Autowired //sirve para inyectar y traer el repositorio
            IUsuarioRepositorio iUsuarioRepositorio; //se instancia el repositorio

    //Se crean métodos para definir las operaciones a realizar en la base de datos.

    //1. Registrar o guardar un usuario.
    public Usuario guardarUsuario(Usuario datosUsuario)throws Exception {// se llama a usuario porque es donde lo quiero hacer y se le activan las excepciones
        try {

           // datosUsuario.setActivo(true);// Asegurar que el usuario se crea como activo
            return iUsuarioRepositorio.save(datosUsuario);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //2. Buscar todos los usuarios.
    public List<Usuario> buscarUsuarios()throws Exception {
        //es una lista porque puede devolver varios usuarios
        try{
            return iUsuarioRepositorio.findAll();
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    //3.Buscar un solo usuario
    public Usuario buscarUsuarioPorId(Long id) throws Exception{
        try{
            Optional<Usuario>usuarioEncontrado=iUsuarioRepositorio.findById(id);
            //hay que castear
            if(usuarioEncontrado.isPresent()){
                return usuarioEncontrado.get();
            }else{
                throw new Exception("usuario no encontrado");
            }
        }catch (Exception error){
            throw  new Exception(error.getMessage());
        }
    }

    ///////////////////////////////////////////
    // 4. Actualizar datos de un usuario.
    public Optional<Usuario> actualizarUsuario(Long id, Usuario datosActualizados) throws Exception {
        try {
            return iUsuarioRepositorio.findById(id)
                    .map(usuario -> {
                        usuario.setNombre(datosActualizados.getNombre());
                        usuario.setContrasena(datosActualizados.getContrasena());
                        usuario.setTelefono(datosActualizados.getTelefono());
                        usuario.setCedula(datosActualizados.getCedula());
                        usuario.setCorreo(datosActualizados.getCorreo());
                        usuario.setFecha_nacimiento(datosActualizados.getFecha_nacimiento());
                        // Otros atributos que puedan ser modificables
                        return iUsuarioRepositorio.save(usuario);
                    });
        } catch (Exception error) {
            throw new Exception("Error al actualizar usuario: " + error.getMessage());
        }
    }
    /////////////////////////////////////////
    // 5. Soft delete (pasar de activo a inactivo).
    public Optional<String> desactivarUsuario(Long id) throws Exception {
        try {
            return iUsuarioRepositorio.findById(id)
                    .map(usuario -> {
                        usuario.setActivo(false); // Cambiar el estado a inactivo
                        iUsuarioRepositorio.save(usuario);
                        return Optional.of("Usuario desactivado correctamente");
                    })
                    .orElseThrow(() -> new Exception("Usuario no encontrado"));
        } catch (Exception error) {
            throw new Exception("Error al desactivar usuario: " + error.getMessage());
        }
    }
    //////////////////////////////////////////
    // 6. Eliminar un usuario permanentemente.
    public Optional<String> eliminarUsuario(Long id) throws Exception {
        try {
            return iUsuarioRepositorio.findById(id)
                    .map(usuario -> {
                        iUsuarioRepositorio.deleteById(id);
                        return Optional.of("Usuario eliminado permanentemente");
                    })
                    .orElseThrow(() -> new Exception("Usuario no encontrado"));
        } catch (Exception error) {
            throw new Exception("Error al eliminar usuario: " + error.getMessage());
        }
    }

}