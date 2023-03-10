package com.example.demo.controllers;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.hibernate.jdbc.Expectation;
import org.hibernate.jdbc.Expectations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.example.demo.models.PRECIO_COMBUSTIBLE;
import com.example.demo.services.PRECIO_COMBUSTIBLEService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.spring.web.json.Json;

@RestController
@RequestMapping("/precio_combustible")
@Api(value = "PrecioCombustibleController", description = "Operaciones de precio de combustible", tags = "Precio Combustibles")
public class PRECIO_COMBUSTIBLEController {

  @Autowired
  PRECIO_COMBUSTIBLEService precio_COMBUSTIBLEService;

  @GetMapping()
  @ApiOperation(value = "Obtener precios de combustible", notes = "Este endpoint devuelve una lista de precios de combustible")
  public ArrayList<PRECIO_COMBUSTIBLE> getPrecioCombustible() {
    ArrayList<PRECIO_COMBUSTIBLE> algo = precio_COMBUSTIBLEService.getPRECIO_COMBUSTIBLEs();
    ArrayList<PRECIO_COMBUSTIBLE> primerosMil = new ArrayList<>();
    for (int i = 0; i < 9000 && i < algo.size(); i++) {
        primerosMil.add(algo.get(i));
    }
      return primerosMil;
  }
  @GetMapping("/Paging")
  @ApiOperation(value = "Obtener precios de combustibles Paginados", notes = "Este endpoint devuelve una lista de precios de combustible")
  public String getData(@ApiParam(value = "Pagina", required = true) @RequestParam("page") int page, @ApiParam(value = "Tamaño pagina", required = true) @RequestParam("pageSize") int pageSize) throws Exception {
     // Calcular el índice de inicio y el número de elementos a devolver
    int startIndex = (page - 1) * pageSize;
    ArrayList<PRECIO_COMBUSTIBLE> algo = precio_COMBUSTIBLEService.getPRECIO_COMBUSTIBLEs();
    int endIndex = Math.min(startIndex + pageSize, algo.size());
    // Crear el objeto JSON para la respuesta
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectNode rootNode = objectMapper.createObjectNode();
    ArrayNode dataArray = objectMapper.createArrayNode();
    rootNode.set("data", dataArray);
    // Agregar los datos a la respuesta JSON
    for (int i = startIndex; i < endIndex; i++) {
      PRECIO_COMBUSTIBLE myData = algo.get(i);
      ObjectNode dataNode = objectMapper.createObjectNode();
      dataNode.put("consecutivo", myData.getCONSECUTIVO());
      dataNode.put("departamento", myData.getDEPARTAMENTO());
      dataNode.put("direccion_AGENTE", myData.getDIRECCION_AGENTE());
      dataNode.put("fecha_REGISTRO", myData.getFECHA_REGISTRO().toString());
      dataNode.put("latitud", myData.getLATITUD());
      dataNode.put("longitud", myData.getLONGITUD());
      dataNode.put("municipio", myData.getMUNICIPIO());
      dataNode.put("nombre_COMERCIAL", myData.getNOMBRE_COMERCIAL());
      dataNode.put("precio_PROMEDIO_REPORTADO", myData.getPRECIO_PROMEDIO_REPORTADO());
      dataNode.put("producto", myData.getCONSECUTIVO());
      dataNode.put("razon_SOCIAL", myData.getRAZON_SOCIAL());
      dataNode.put("valor_PRECIO", myData.getVALOR_PRECIO());
      dataArray.add(dataNode);
    }
    // Agregar información de paginación a la respuesta JSON
    int totalPages = (int) Math.ceil((double) algo.size() / pageSize);
    rootNode.put("page", page);
    rootNode.put("pageSize", pageSize);
    rootNode.put("totalPages", totalPages);
    // Convertir el objeto JSON a una cadena y devolverlo
    return objectMapper.writeValueAsString(rootNode);
  }

}

