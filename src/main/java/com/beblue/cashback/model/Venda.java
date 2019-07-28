package com.beblue.cashback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
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
	private List<Disco> discos;


	public Venda() {
		this.data = LocalDate.now();
	}

	public List<Disco> getDiscos() {
		if (discosVendidos.isEmpty()) {
			return Collections.emptyList();
		}

		return discosVendidos.stream()
				.map( d -> new Disco(d.getDisco().getId(),
									 d.getDisco().getIdentificadorSpotiy(),
									 d.getDisco().getNome(),
									 d.getDisco().getGenero(),
						             d.getDisco().getPreco()))
				.collect(Collectors.toList());
	}
}
