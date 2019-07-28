package com.beblue.cashback.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity(name = "disco_venda")
public class DiscoVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_venda", nullable = false)
	private Venda venda;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_disco")
	private Disco disco;

	@Column(name = "vl_cashback")
	private BigDecimal valorCashback;

	@Column(name="vl_unitario", nullable = false, precision = 10, scale  = 2)
	private BigDecimal valorUnitario;



}
