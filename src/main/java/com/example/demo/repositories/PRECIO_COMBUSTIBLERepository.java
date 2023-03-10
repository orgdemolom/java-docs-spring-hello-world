package com.example.demo.repositories;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PRECIO_COMBUSTIBLE;

@Repository
public interface PRECIO_COMBUSTIBLERepository extends JpaRepository<PRECIO_COMBUSTIBLE, Integer>{
    Page<PRECIO_COMBUSTIBLE> findAll(org.springframework.data.domain.Pageable pageable);    
}
