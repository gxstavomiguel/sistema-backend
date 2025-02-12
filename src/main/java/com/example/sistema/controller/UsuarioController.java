package com.example.sistema.controller;

import com.example.sistema.entity.Usuario;
import com.example.sistema.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/usuario/")
public class UsuarioController {

    UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Usuario usuario){
        try {
            String msg = usuarioService.save(usuario);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Usuario>> findAll(){
        try {
            List<Usuario> lista = usuarioService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable Long id){
        try {
            Optional<Usuario> usuario = usuarioService.findById(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Usuario usuario, @PathVariable Long id){
        try {
            String msg = usuarioService.update(usuario, id);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        try {
            usuarioService.delete(id);
            String msg = "Usuário Deletado com sucesso";
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
