package com.uco.graduationproject.burstcar.infrastructure.controller;

public class ResponseToken<T> {

    private T valor;
    public ResponseToken() {
    }

    public ResponseToken(T valor) {
        this.valor = valor;
    }
    public T getValor() {
        return valor;
    }
}
