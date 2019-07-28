package com.beblue.cashback.service;

import com.beblue.cashback.exception.ApiException;
import com.beblue.cashback.model.Venda;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

public class VendaServiceTest {

	@Mock
	VendaService service;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deveObterAlbunPorId() {

		try {
			Mockito.when(service.obterPorId(1L)).thenReturn(new Venda());
			Venda venda = service.obterPorId(1L);

			Assert.assertNotNull(venda);

		} catch (ApiException e) {
			fail("Falha ao testar obter venda por id");
		}
	}

}
