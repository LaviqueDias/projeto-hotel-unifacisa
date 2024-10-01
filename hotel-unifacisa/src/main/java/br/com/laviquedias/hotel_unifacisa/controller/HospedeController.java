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

import br.com.laviquedias.hotel_unifacisa.dto.HospedeDTO;
import br.com.laviquedias.hotel_unifacisa.service.HospedeService;

@RestController
@RequestMapping("/hospedes")
public class HospedeController {

    private HospedeService hospedeService;

    public HospedeController(HospedeService hospedeService) {
        this.hospedeService = hospedeService;
    }

    @PostMapping
    Set<HospedeDTO> create(@RequestBody HospedeDTO hospedeDTO){
        return hospedeService.create(hospedeDTO);
    }

    @GetMapping
    Set<HospedeDTO> list(){
        return hospedeService.list();
    }

    @PutMapping
    Set<HospedeDTO> update(@RequestBody HospedeDTO hospedeDTO){
        return hospedeService.update(hospedeDTO);
    }

    @DeleteMapping("{cpf}")
    Set<HospedeDTO> delete(@PathVariable("cpf") String cpf){
        return hospedeService.delete(cpf);
    }
    

}
