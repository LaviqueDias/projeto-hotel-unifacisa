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

import br.com.laviquedias.hotel_unifacisa.dto.ReservaDTO;
import br.com.laviquedias.hotel_unifacisa.service.ReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public Set<ReservaDTO> create(@RequestBody ReservaDTO reserva){
        return reservaService.create(reserva);
    }

    @GetMapping
    public Set<ReservaDTO> list(){
        return reservaService.list();
    }

    @PutMapping
    public Set<ReservaDTO> update(@RequestBody ReservaDTO reserva){
        return reservaService.update(reserva);
    }

    @DeleteMapping("{idReserva}")
    public Set<ReservaDTO> delete(@PathVariable("idReserva") Long idReserva){
        return reservaService.delete(idReserva);
    }
    

}
