package com.prestamo.service;

import java.util.List;

import com.prestamo.kafka.service.PaisEventService;
import org.springframework.stereotype.Service;

import com.prestamo.entity.Pais;
import com.prestamo.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService {

	private final PaisRepository paisRepository;

	private final PaisEventService paisEventService;

    public PaisServiceImpl(PaisRepository paisRepository, PaisEventService paisEventService) {
        this.paisRepository = paisRepository;
        this.paisEventService = paisEventService;
    }

    @Override
	public List<Pais> findAll() {
		return paisRepository.findAll();
	}

	@Override
	public Pais insertaPais(Pais pais) {
		paisEventService.publish(pais); // Publica el evento al kafka
		return paisRepository.save(pais); // Registra en la base de datos
	}

}
