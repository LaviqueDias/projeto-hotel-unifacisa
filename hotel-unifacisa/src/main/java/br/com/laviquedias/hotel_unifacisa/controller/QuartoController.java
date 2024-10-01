package br.com.laviquedias.hotel_unifacisa.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.laviquedias.hotel_unifacisa.dto.QuartoDTO;
import br.com.laviquedias.hotel_unifacisa.service.QuartoService;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    private QuartoService quartoService;

    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @PostMapping
    public Set<QuartoDTO> create(@RequestBody QuartoDTO quarto){
        return quartoService.create(quarto);
    }

    @GetMapping
    public Set<QuartoDTO> list(){
        return quartoService.list();
    }

    @PutMapping
    public Set<QuartoDTO> update(@RequestBody QuartoDTO quarto){
        return quartoService.update(quarto);
    }

    @DeleteMapping("{numeroQuarto}")
    public Set<QuartoDTO> delete(@PathVariable("numeroQuarto") Long numeroQuarto){
        return quartoService.delete(numeroQuarto);
    }
    

}
