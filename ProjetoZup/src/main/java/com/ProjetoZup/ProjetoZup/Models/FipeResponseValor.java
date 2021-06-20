package com.ProjetoZup.ProjetoZup.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FipeResponseValor {

    @JsonProperty("Valor")
    public String valor;
    @JsonProperty("Marca")
    public String marca;
    @JsonProperty("Modelo")
    public String modelo;
    @JsonProperty("AnoModelo")
    public int anoModelo;
    @JsonProperty("Combustivel")
    public String combustivel;
    @JsonProperty("CodigoFipe")
    public String codigoFipe;
    @JsonProperty("MesReferencia")
    public String mesReferencia;
    @JsonProperty("TipoVeiculo")
    public int tipoVeiculo;
    @JsonProperty("SiglaCombustivel")
    public String siglaCombustivel;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public int getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        this.siglaCombustivel = siglaCombustivel;
    }


}


