package com.prestamo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prestamo.entity.DataCatalogo;
import com.prestamo.repository.DataCatalogoRepository;

@Service
public class DataCatalogoServiceImpl implements DataCatalogoService{

	private final DataCatalogoRepository repository;

    public DataCatalogoServiceImpl(DataCatalogoRepository repository) {
        this.repository = repository;
    }

    @Override
	public List<DataCatalogo> listaPorCatalogo(int idCatalogo) {
		return repository.listaPorCatalogo(idCatalogo);
	}
	

}
