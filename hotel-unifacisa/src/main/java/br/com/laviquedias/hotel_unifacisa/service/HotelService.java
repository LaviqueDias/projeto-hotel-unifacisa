package br.com.laviquedias.hotel_unifacisa.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.domain.Sort;

import br.com.laviquedias.hotel_unifacisa.dto.HotelDTO;
import br.com.laviquedias.hotel_unifacisa.entity.Hotel;
import br.com.laviquedias.hotel_unifacisa.repository.HotelRepository;

public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    
    public Set<HotelDTO> create(HotelDTO hotelDTO){
        Hotel hotel = new Hotel(hotelDTO);
        hotelRepository.save(hotel);
        return list();
    }

    public Set<HotelDTO> list(){
        Sort sort = Sort.by("idHotel").ascending();
        Set<HotelDTO> hoteis = new HashSet<HotelDTO>();

        for (Hotel hotel : hotelRepository.findAll(sort)) {
            HotelDTO hotelDTO = new HotelDTO(hotel);
            hoteis.add(hotelDTO);
        }

        return hoteis;
    }

    public Set<HotelDTO> update(HotelDTO hotelDTO){
        Hotel hotel = new Hotel(hotelDTO);
        hotelRepository.save(hotel);
        return list();
    }

    public Set<HotelDTO> delete(Long idHotel){
        hotelRepository.deleteById(idHotel);
        return list();
    }

}
