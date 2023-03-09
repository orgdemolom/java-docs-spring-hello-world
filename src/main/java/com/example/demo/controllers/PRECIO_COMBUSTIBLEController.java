package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.PRECIO_COMBUSTIBLE;
import com.example.demo.services.PRECIO_COMBUSTIBLEService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/precio_combustible")
@Api(value = "PrecioCombustibleController", description = "Operaciones de precio de combustible", tags = "Precio Combustibles")
public class PRECIO_COMBUSTIBLEController {

  @Autowired
  PRECIO_COMBUSTIBLEService precio_COMBUSTIBLEService;

  @GetMapping()
  @ApiOperation(value = "Obtener precios de combustible", notes = "Este endpoint devuelve una lista de precios de combustible")
  public ArrayList<PRECIO_COMBUSTIBLE> getPrecioCombustible() {
    return precio_COMBUSTIBLEService.getPRECIO_COMBUSTIBLEs();
  }

}

