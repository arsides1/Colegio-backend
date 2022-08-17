package com.colegio.web.service;

import com.colegio.web.model.Grado;
import com.colegio.web.repository.GradoRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional
public class GradoServiceImpl implements GradoService {


	private final GradoRepositoryJPA gradoRepo;


	@Override
	public List<Grado> listarGrado() {
		List<Grado>grado = StreamSupport.stream(
				this.gradoRepo.findAll().spliterator(),false).collect(Collectors.toList());
		return grado;
	}
}
