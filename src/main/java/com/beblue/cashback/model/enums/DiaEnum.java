package com.beblue.cashback.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;

@Getter
@AllArgsConstructor
public enum DiaEnum {

	DOMINGO(DayOfWeek.SUNDAY.getValue()),
	SEGUNDA(DayOfWeek.MONDAY.getValue()),
	TERCA(DayOfWeek.TUESDAY.getValue()),
	QUARTA(DayOfWeek.WEDNESDAY.getValue()),
	QUINTA(DayOfWeek.THURSDAY.getValue()),
	SEXTA(DayOfWeek.FRIDAY.getValue()),
	SABADO(DayOfWeek.SATURDAY.getValue());

	private int codigo;

}
