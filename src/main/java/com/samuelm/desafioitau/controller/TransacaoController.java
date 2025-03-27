package com.samuelm.desafioitau.controller;

import com.samuelm.desafioitau.dto.TransacaoRequest;
import com.samuelm.desafioitau.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    private final TransacaoService service;

    public TransacaoController(TransacaoService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody TransacaoRequest request){
        service.salvar(request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void salvar(){
        service.deletar();
    }
}
