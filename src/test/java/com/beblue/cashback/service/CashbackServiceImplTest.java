package com.beblue.cashback.service;

import com.beblue.cashback.repository.CashbackRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CashbackServiceImplTest {

    @InjectMocks
    private CashbackServiceImpl cashbackService;

    @Mock
    private CashbackRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }



}