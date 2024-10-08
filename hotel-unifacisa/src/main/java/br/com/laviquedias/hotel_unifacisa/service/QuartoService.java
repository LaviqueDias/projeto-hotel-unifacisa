package br.com.laviquedias.hotel_unifacisa.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.laviquedias.hotel_unifacisa.dto.QuartoDTO;
import br.com.laviquedias.hotel_unifacisa.entity.Quarto;
import br.com.laviquedias.hotel_unifacisa.repository.QuartoRepository;

@Service
public class QuartoService {

    private QuartoRepository quartoRepository;

    public QuartoService(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public Set<QuartoDTO> create(QuartoDTO quartoDTO){
        Quarto quarto = new Quarto(quartoDTO);

        if(quarto.getHotelQuarto() != null){
            quarto.getHotelQuarto().getQuartos().add(quarto);
            quartoRepository.save(quarto);
        }
        
        return list();
    } 

    public Set<QuartoDTO> list(){
        Sort sort = Sort.by("numeroQuarto").ascending();
        Set<QuartoDTO> quartos = new HashSet<QuartoDTO>();

        for (Quarto quarto : quartoRepository.findAll(sort)) {
            QuartoDTO quartoDTO = new QuartoDTO(quarto);
            quartos.add(quartoDTO);
        }

        return quartos;
    }

    public Set<QuartoDTO> update(QuartoDTO quartoDTO){
        Quarto quarto = new Quarto(quartoDTO);
        quartoRepository.save(quarto);
        return list();
    }

    public Set<QuartoDTO> delete(Long numeroQuarto){
        quartoRepository.deleteById(numeroQuarto);
        return list();
    }

}
