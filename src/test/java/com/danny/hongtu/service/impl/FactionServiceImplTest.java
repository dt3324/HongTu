package com.danny.hongtu.service.impl;

import com.danny.hongtu.service.FactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactionServiceImplTest {

    @Resource
    private FactionService factionService;

    @Test
    public void insertOne() {
        factionService.insertOne();
    }
    @Test
    public void findAll() {
        factionService.findAll();
    }
}
