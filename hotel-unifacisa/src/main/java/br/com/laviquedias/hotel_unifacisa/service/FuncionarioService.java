package br.com.laviquedias.hotel_unifacisa.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.laviquedias.hotel_unifacisa.dto.FuncionarioDTO;
import br.com.laviquedias.hotel_unifacisa.entity.Funcionario;
import br.com.laviquedias.hotel_unifacisa.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


    public Set<FuncionarioDTO> create(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = new Funcionario(funcionarioDTO);

        if(funcionario.getHotelFuncionario() != null){
            funcionario.getHotelFuncionario().getFuncionarios().add(funcionario);
            funcionarioRepository.save(funcionario);
        }
        
        return list();
    }

    public Set<FuncionarioDTO> list(){
        Sort sort = Sort.by("nome").ascending();
        Set<FuncionarioDTO> funcionarios = new HashSet<>();

        for (Funcionario funcionario : funcionarioRepository.findAll(sort)) {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
            funcionarios.add(funcionarioDTO);
        }

        return funcionarios;
    
    }
    public Set<FuncionarioDTO> update(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = new Funcionario(funcionarioDTO);
        funcionarioRepository.save(funcionario);
        return list();
    }

    public Set<FuncionarioDTO> delete(String cpf){
        funcionarioRepository.deleteById(cpf);
        return list();
    }


}
