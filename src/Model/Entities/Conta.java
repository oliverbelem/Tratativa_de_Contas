package Model.Entities;

import Model.Exceptions.BusinessException;

public class Conta {

    private Integer numeroConta;
    private String titular;
    private Double saldo;
    private Double limiteSaque;

    public Conta(Integer numeroConta, String titular, Double saldo, Double limiteSaque) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(Double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }

    public void deposito(double valor){
        saldo += valor;
    }

    public void saque(double valor){
        validacaoSaque(valor);
        saldo -= valor;
    }

    private void validacaoSaque(double valor){
        if(valor > getLimiteSaque()){
            throw new BusinessException("Você não pode realizar o saque, pois excede seu limite...");
        }
        if (valor > getSaldo()) {
            throw new BusinessException("Você não tem saldo suficiente...");
        }
    }

    @Override
    public String toString() {
        return "Novo Saldo: R$"
                + String.format("%.2f", getSaldo());
    }
}
