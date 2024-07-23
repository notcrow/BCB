package BCB.BCB.dtos;

import java.time.LocalDate;

public class SaldoDTO {
    private Long Id_saldo;
    private Long Id_cliente;
    private Long Id_sms;
    private Long Id_recarga;
    private boolean status;
    private LocalDate data_movto;
    private double valor_anterior;
    private double valor;
    private double valor_saldo;
    public Long getId_saldo() {
        return Id_saldo;
    }
    public void setId_saldo(Long id_saldo) {
        Id_saldo = id_saldo;
    }
    public Long getId_cliente() {
        return Id_cliente;
    }
    public void setId_cliente(Long id_cliente) {
        Id_cliente = id_cliente;
    }
    public Long getId_sms() {
        return Id_sms;
    }
    public void setId_sms(Long id_sms) {
        Id_sms = id_sms;
    }
    public Long getId_recarga() {
        return Id_recarga;
    }
    public void setId_recarga(Long id_recarga) {
        Id_recarga = id_recarga;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public LocalDate getData_movto() {
        return data_movto;
    }
    public void setData_movto(LocalDate data_movto) {
        this.data_movto = data_movto;
    }
    public double getValor_anterior() {
        return valor_anterior;
    }
    public void setValor_anterior(double valor_anterior) {
        this.valor_anterior = valor_anterior;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getValor_saldo() {
        return valor_saldo;
    }
    public void setValor_saldo(double valor_saldo) {
        this.valor_saldo = valor_saldo;
    }
}
