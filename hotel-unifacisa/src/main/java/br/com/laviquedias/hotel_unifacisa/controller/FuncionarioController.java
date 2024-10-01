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

import br.com.laviquedias.hotel_unifacisa.dto.FuncionarioDTO;
import br.com.laviquedias.hotel_unifacisa.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    Set<FuncionarioDTO> create(@RequestBody FuncionarioDTO funcionarioDTO){
        return funcionarioService.create(funcionarioDTO);
    }

    @GetMapping
    Set<FuncionarioDTO> list(){
        return funcionarioService.list();
    }

    @PutMapping
    Set<FuncionarioDTO> update(@RequestBody FuncionarioDTO funcionarioDTO){
        return funcionarioService.update(funcionarioDTO);
    }

    @DeleteMapping("{cpf}")
    Set<FuncionarioDTO> delete(@PathVariable("cpf") String cpf){
        return funcionarioService.delete(cpf);
    }


}
