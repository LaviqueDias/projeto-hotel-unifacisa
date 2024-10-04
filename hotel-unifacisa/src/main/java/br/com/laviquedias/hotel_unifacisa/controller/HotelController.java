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

import br.com.laviquedias.hotel_unifacisa.dto.HotelDTO;
import br.com.laviquedias.hotel_unifacisa.service.HotelService;

@RestController
@RequestMapping("/hoteis")
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public Set<HotelDTO> create(@RequestBody HotelDTO hotel){
        return hotelService.create(hotel);
    }

    @GetMapping
    public Set<HotelDTO> list(){
        return hotelService.list();
    }

    @PutMapping
    public Set<HotelDTO> update(@RequestBody HotelDTO hotel){
        return hotelService.update(hotel);
    }

    @DeleteMapping("{idHotel}")
    public Set<HotelDTO> delete(@PathVariable("idhotel") Long idHotel){
        return hotelService.delete(idHotel);
    }

}
