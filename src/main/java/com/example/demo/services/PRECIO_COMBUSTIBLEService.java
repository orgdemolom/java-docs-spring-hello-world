package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.PRECIO_COMBUSTIBLE;
import com.example.demo.repositories.PRECIO_COMBUSTIBLERepository;

@Service
public class PRECIO_COMBUSTIBLEService {
    @Autowired
    PRECIO_COMBUSTIBLERepository precio_COMBUSTIBLERepository;
    
    public ArrayList<PRECIO_COMBUSTIBLE> getPRECIO_COMBUSTIBLEs(){
        return (ArrayList<PRECIO_COMBUSTIBLE>) precio_COMBUSTIBLERepository.findAll();
    }
}
