package br.com.laviquedias.hotel_unifacisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.laviquedias.hotel_unifacisa.entity.Hospede;

public interface HospedeRepository  extends JpaRepository<Hospede, String>{

}
