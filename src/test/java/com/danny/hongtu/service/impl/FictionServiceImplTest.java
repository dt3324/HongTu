package com.danny.hongtu.service.impl;

import com.danny.hongtu.service.FictionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FictionServiceImplTest {

    @Resource
    private FictionService fictionService;

    @Test
    public void insertOne() {
        fictionService.insertOne();
    }
    @Test
    public void findAll() {
        fictionService.findAll();
    }
}