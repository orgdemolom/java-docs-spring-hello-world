package com.example.demo.services;

import java.util.ArrayList;
import java.util.stream.Stream;

import javax.persistence.Cacheable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.models.PRECIO_COMBUSTIBLE;
import com.example.demo.repositories.PRECIO_COMBUSTIBLERepository;

@Service
public class PRECIO_COMBUSTIBLEService {
    @Autowired
    PRECIO_COMBUSTIBLERepository precio_COMBUSTIBLERepository;
    
    @org.springframework.cache.annotation.Cacheable("preciocombustible")
    public ArrayList<PRECIO_COMBUSTIBLE> getPRECIO_COMBUSTIBLEs(){
        return (ArrayList<PRECIO_COMBUSTIBLE>) precio_COMBUSTIBLERepository.findAll();
    }

    public Page<PRECIO_COMBUSTIBLE> getPRECIO_COMBUSTIBLESPages(org.springframework.data.domain.Pageable pageable){
        return precio_COMBUSTIBLERepository.findAll(pageable);
    }

    public Stream<PRECIO_COMBUSTIBLE> getPRECIO_COMBUSTIBLESStream(){
    return precio_COMBUSTIBLERepository.findAll().stream();
    }
}
