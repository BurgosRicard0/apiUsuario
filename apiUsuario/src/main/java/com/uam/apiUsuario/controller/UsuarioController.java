package com.uam.apiUsuario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.uam.apiUsuario.model.Usuario;
import com.uam.apiUsuario.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	@Autowired
    private UsuarioService usuarioService;

	@Autowired
    private RestTemplate restTemplate; 

    @GetMapping("/hoteles/{hotelId}")
    public ResponseEntity<String> getHotelInfo(@PathVariable Long hotelId) {
        String hotelApiUrl = "http://localhost:8080/api/hotel/" + hotelId; 
        ResponseEntity<String> response = restTemplate.getForEntity(hotelApiUrl, String.class);
        String hotelInfo = response.getBody();

        return ResponseEntity.ok(hotelInfo);
    }

    @Operation(summary = "Obtener lista de usuarios", description = "Devuelve una lista de todos los usuarios", tags={  })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa") })
    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getUsuarios() {
    	try {
        List<Usuario> usuarios = usuarioService.getUsuario();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    	} catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Operation(summary = "Obtener la informacion de un Usuario", description = "Obtener la informacion de un Usuario", tags={  })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa") })
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
    @Operation(summary = "Dar de alta la informacion de un Usuario", description = "Dar de alta la informacion de un Usuario", tags={  })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa") })
    @PostMapping("/")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.addUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar la informacion de un Usuario", description = "Actualizar la informacion de un Usuario", tags={  })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa") })
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.updateUsuario(id, usuario);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    }
    @Operation(summary = "Eliminar la informacion de un Usuario", description = "Eliminar la informacion de un Usuario", tags={  })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Respuesta exitosa") })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
