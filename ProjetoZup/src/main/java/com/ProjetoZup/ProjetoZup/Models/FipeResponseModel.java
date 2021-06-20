package com.ProjetoZup.ProjetoZup.Models;

public class FipeResponseModel {
    private String nome;
    private Object codigo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return String.valueOf(this.codigo);
    }
    public void setCodigo(Object codigo) {
        this.codigo = codigo;
    }
}
