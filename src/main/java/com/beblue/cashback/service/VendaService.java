package com.beblue.cashback.service;

import com.beblue.cashback.common.Messages;
import com.beblue.cashback.exception.ApiException;
import com.beblue.cashback.model.Disco;
import com.beblue.cashback.model.ItemVenda;
import com.beblue.cashback.model.Venda;
import com.beblue.cashback.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;

	@Autowired
	Messages messages;

	public Venda obterPorId(Long id) throws ApiException {
		Optional<Venda> optVenda = repository.findById(id);

		if (!optVenda.isPresent()) {
			throw new ApiException(messages.get("venda.nao.encontrada"));
		}

		return optVenda.get();
	}

	public Venda registrarVenda(List<Disco> discos) throws ApiException {

		if (discos.isEmpty()) {
			throw new ApiException(messages.get("erro.venda.discos.nulo"));
		}

		return repository.save(new Venda(null, LocalDate.now(), null));

	}


}
