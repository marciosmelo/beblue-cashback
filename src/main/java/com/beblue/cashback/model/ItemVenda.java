package com.beblue.cashback.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Entity(name = "item_venda")
public class ItemVenda {

	@Id
	private Long id;

	@Column(name = "vl_cashback")
	private BigDecimal valorCashback;

	@Column(name = "cd_album")
	private String codigoAlbum;

	@Column(name="vl_unitario", nullable = false, precision = 10, scale  = 2)
	private BigDecimal valorUnitario;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_venda", nullable = false)
	private Venda venda;

	@ManyToOne
	@JoinColumn(name = "id_cashback", nullable = false)
	private Cashback cashback;
}
