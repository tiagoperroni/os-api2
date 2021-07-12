package com.tiagoperroni.principal.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoperroni.principal.domain.Cliente;
import com.tiagoperroni.principal.domain.OS;
import com.tiagoperroni.principal.domain.Tecnico;
import com.tiagoperroni.principal.domain.enums.Prioridade;
import com.tiagoperroni.principal.domain.enums.Status;
import com.tiagoperroni.principal.repositories.ClienteRepository;
import com.tiagoperroni.principal.repositories.OSRepository;
import com.tiagoperroni.principal.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;
	
	public void instaciaDB() {
		
		Tecnico t1 = new Tecnico(null, "Tiago Perroni", "052.583.099-59", "(44) 99948-2997");
		Tecnico t2 = new Tecnico(null, "Tiago Perroni", "178.265.800-99", "(44) 99948-2997");
		Tecnico t3 = new Tecnico(null, "Tiago Perroni", "936.254.840-21", "(44) 99948-2997");
		Cliente c1 = new Cliente(null, "Marcos Souza", "884.538.660-07", "(44) 99955-2954");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create os", Status.ABERTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
		
	}

}
