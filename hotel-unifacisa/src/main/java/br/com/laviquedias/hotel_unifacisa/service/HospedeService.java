package br.com.laviquedias.hotel_unifacisa.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.laviquedias.hotel_unifacisa.dto.HospedeDTO;
import br.com.laviquedias.hotel_unifacisa.entity.Hospede;
import br.com.laviquedias.hotel_unifacisa.repository.HospedeRepository;

@Service
public class HospedeService {

    private HospedeRepository hospedeRepository;

    public HospedeService(HospedeRepository hospedeRepository) {
        this.hospedeRepository = hospedeRepository;
    }

    public Set<HospedeDTO> create(HospedeDTO hospedeDTO){
        Hospede hospede = new Hospede(hospedeDTO);
        hospedeRepository.save(hospede);
        return list();
    }
    
    public Set<HospedeDTO> list(){
        Sort sort = Sort.by("nome").ascending();
        Set<HospedeDTO> hospedes = new HashSet<>();

        for (Hospede hospede : hospedeRepository.findAll(sort)) {
            HospedeDTO hospedeDTO = new HospedeDTO(hospede);
            hospedes.add(hospedeDTO);
        }

        return hospedes;
    }

    public Set<HospedeDTO> update(HospedeDTO hospedeDTO){
        Hospede hospede = new Hospede(hospedeDTO);
        hospedeRepository.save(hospede);
        return list();
    }

    public Set<HospedeDTO> delete(String cpf){
        hospedeRepository.deleteById(cpf);
        return list();
    }

}
