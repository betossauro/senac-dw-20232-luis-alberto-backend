package br.sc.senac.dw.exception;

public class CampoInvalidoException extends Exception {
    public CampoInvalidoException(String mensagem) {
        super(mensagem);
    }
}