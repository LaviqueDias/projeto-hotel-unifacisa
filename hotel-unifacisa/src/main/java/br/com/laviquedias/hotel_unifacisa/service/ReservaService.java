package br.com.laviquedias.hotel_unifacisa.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.laviquedias.hotel_unifacisa.dto.ReservaDTO;
import br.com.laviquedias.hotel_unifacisa.entity.Reserva;
import br.com.laviquedias.hotel_unifacisa.repository.ReservaRepository;

@Service
public class ReservaService {

    private ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    
    public Set<ReservaDTO> create(ReservaDTO reservaDTO){
        Reserva reserva = new Reserva(reservaDTO);
        reservaRepository.save(reserva);
        return list();
    }

    public Set<ReservaDTO> list(){
        Sort sort = Sort.by("idReserva").ascending();
        Set<ReservaDTO> reservas = new HashSet<ReservaDTO>();

        for (Reserva reserva : reservaRepository.findAll(sort)) {
            ReservaDTO reservaDTO = new ReservaDTO(reserva);
            reservas.add(reservaDTO);
        }

        return reservas;
    }

    public Set<ReservaDTO> update(ReservaDTO reservaDTO){
        Reserva reserva = new Reserva(reservaDTO);
        reservaRepository.save(reserva);
        return list();
    }

    public Set<ReservaDTO> delete(Long idReserva){
        reservaRepository.deleteById(idReserva);
        return list();
    }

}
