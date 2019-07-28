package com.beblue.cashback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity(name = "venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "dt_venda")
	private LocalDate data;

	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<DiscoVenda> discosVendidos;

	@Transient
	private BigDecimal valorTotalCashback;

	@Transient
	private List<AlbumVendido> albunsVendidos;

	public Venda() {
		this.data = LocalDate.now();
	}

	public List<AlbumVendido> getAlbunsVendidos() {
		if (discosVendidos.isEmpty()) {
			return Collections.emptyList();
		}

		return discosVendidos.stream()
				.map( d -> new AlbumVendido(d.getDisco().getNome(),
									 		d.getDisco().getGenero(),
						             		d.getValorUnitario(),
											d.getValorCashback()))
				.collect(Collectors.toList());
	}

	public BigDecimal getValorTotalCashback() {
		if (discosVendidos.isEmpty()) {
			return BigDecimal.ZERO;
		}

		return discosVendidos.stream()
				.map(DiscoVenda::getValorCashback)
				.reduce(BigDecimal.ZERO,BigDecimal::add);

	}

}
