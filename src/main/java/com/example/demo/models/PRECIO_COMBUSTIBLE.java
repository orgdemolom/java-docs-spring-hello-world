package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "PRECIO_COMBUSTIBLE", schema = "DWH")
@Immutable
public class PRECIO_COMBUSTIBLE {
    @Id
    @Column(name = "CONSECUTIVO", columnDefinition = "bigint", nullable = true)
    private Integer CONSECUTIVO;

    @Column(name = "RAZON_SOCIAL", columnDefinition = "varchar(256)", nullable = true)
    private String RAZON_SOCIAL;

    @Column(name = "NOMBRE_COMERCIAL", columnDefinition = "varchar(128)", nullable = true)
    private String NOMBRE_COMERCIAL;

    @Column(name = "DIRECCION_AGENTE", columnDefinition = "varchar(256)", nullable = true)
    private String DIRECCION_AGENTE;

    @Column(name = "LATITUD", columnDefinition = "real", nullable = true)
    private Double LATITUD;

    @Column(name = "LONGITUD", columnDefinition = "real", nullable = true)
    private Double LONGITUD;

    @Column(name = "DEPARTAMENTO", columnDefinition = "varchar(256)", nullable = true)
    private String DEPARTAMENTO;

    @Column(name = "MUNICIPIO", columnDefinition = "varchar(256)", nullable = true)
    private String MUNICIPIO;

    @Column(name = "PRODUCTO", columnDefinition = "varchar(64)", nullable = true)
    private String PRODUCTO;

    @Column(name = "FECHA_REGISTRO", columnDefinition = "date", nullable = false)
    private Date FECHA_REGISTRO;

    @Column(name = "VALOR_PRECIO", columnDefinition = "numeric(12,2)", nullable = true)
    private Double VALOR_PRECIO;

    @Column(name = "PRECIO_PROMEDIO_REPORTADO", columnDefinition = "numeric(12,2)", nullable = true)
    private Double PRECIO_PROMEDIO_REPORTADO;

    public Integer getCONSECUTIVO() {
        return CONSECUTIVO;
    }

    public void setCONSECUTIVO(Integer cONSECUTIVO) {
        CONSECUTIVO = cONSECUTIVO;
    }

    public String getRAZON_SOCIAL() {
        return RAZON_SOCIAL;
    }

    public void setRAZON_SOCIAL(String rAZON_SOCIAL) {
        RAZON_SOCIAL = rAZON_SOCIAL;
    }

    public String getNOMBRE_COMERCIAL() {
        return NOMBRE_COMERCIAL;
    }

    public void setNOMBRE_COMERCIAL(String nOMBRE_COMERCIAL) {
        NOMBRE_COMERCIAL = nOMBRE_COMERCIAL;
    }

    public String getDIRECCION_AGENTE() {
        return DIRECCION_AGENTE;
    }

    public void setDIRECCION_AGENTE(String dIRECCION_AGENTE) {
        DIRECCION_AGENTE = dIRECCION_AGENTE;
    }

    public Double getLATITUD() {
        return LATITUD;
    }

    public void setLATITUD(Double lATITUD) {
        LATITUD = lATITUD;
    }

    public Double getLONGITUD() {
        return LONGITUD;
    }

    public void setLONGITUD(Double lONGITUD) {
        LONGITUD = lONGITUD;
    }

    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public void setDEPARTAMENTO(String dEPARTAMENTO) {
        DEPARTAMENTO = dEPARTAMENTO;
    }

    public String getMUNICIPIO() {
        return MUNICIPIO;
    }

    public void setMUNICIPIO(String mUNICIPIO) {
        MUNICIPIO = mUNICIPIO;
    }

    public String getPRODUCTO() {
        return PRODUCTO;
    }

    public void setPRODUCTO(String pRODUCTO) {
        PRODUCTO = pRODUCTO;
    }

    public Double getVALOR_PRECIO() {
        return VALOR_PRECIO;
    }

    public void setVALOR_PRECIO(Double vALOR_PRECIO) {
        VALOR_PRECIO = vALOR_PRECIO;
    }

    public Double getPRECIO_PROMEDIO_REPORTADO() {
        return PRECIO_PROMEDIO_REPORTADO;
    }

    public void setPRECIO_PROMEDIO_REPORTADO(Double pRECIO_PROMEDIO_REPORTADO) {
        PRECIO_PROMEDIO_REPORTADO = pRECIO_PROMEDIO_REPORTADO;
    }

    public Date getFECHA_REGISTRO() {
        return FECHA_REGISTRO;
    }

    public void setFECHA_REGISTRO(Date fECHA_REGISTRO) {
        FECHA_REGISTRO = fECHA_REGISTRO;
    }
}
