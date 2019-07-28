package com.beblue.cashback.service;

import com.beblue.cashback.common.Messages;
import com.beblue.cashback.exception.ApiException;
import com.beblue.cashback.model.Disco;
import com.beblue.cashback.model.DiscoVenda;
import com.beblue.cashback.model.Venda;
import com.beblue.cashback.repository.VendaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VendaService {

	Logger logger = LoggerFactory.getLogger(VendaService.class);

    @Autowired
    private VendaRepository repository;

    @Autowired
    private CashbackService cashbackService;

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
        try {
            Venda vendaRegistrada = this.salvar(this.obterDiscosVendidos(discos));

            return this.obterPorId(vendaRegistrada.getId());

        } catch (Exception e) {
        	logger.error("Erro ao Salvar Venda -> {}", e.getMessage());
            throw new ApiException(messages.get("erro.salvar.venda"));
        }
    }

    @Transactional
    private Venda salvar(List<DiscoVenda> discosVendidos) throws ApiException {
    	Venda venda = new Venda();

		discosVendidos.stream().forEach(d -> d.setVenda(venda));

    	venda.setDiscosVendidos(discosVendidos);

		return repository.save(venda);

    }

    private List<DiscoVenda> obterDiscosVendidos(List<Disco> discos) {
        return discos.stream()
                .map(disco -> externalToDiscoVenda.apply(disco))
                .collect(Collectors.toList());
    }

    private Function<Disco, DiscoVenda> externalToDiscoVenda =
            disco -> new DiscoVenda(null, null, disco, this.obterCashback(disco), disco.getPreco());

    private BigDecimal obterCashback(Disco disco) {
        return BigDecimal.ZERO;
    }


}
