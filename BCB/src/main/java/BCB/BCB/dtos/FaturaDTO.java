package BCB.BCB.dtos;

public class FaturaDTO {
    private long Id_movto;
    private long Id_fatura;
    private long Id_sms;
    private long Id_cliente;
    private boolean status;
    private double valor_anterior; 
    private double valor; 
    private double valor_fatura;
    
    public long getId_movto() {
        return Id_movto;
    }
    public void setId_movto(long id_movto) {
        Id_movto = id_movto;
    }
    public long getId_fatura() {
        return Id_fatura;
    }
    public void setId_fatura(long id_fatura) {
        Id_fatura = id_fatura;
    }
    public long getId_sms() {
        return Id_sms;
    }
    public void setId_sms(long id_sms) {
        Id_sms = id_sms;
    }
    public long getId_cliente() {
        return Id_cliente;
    }
    public void setId_cliente(long id_cliente) {
        Id_cliente = id_cliente;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
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
    public double getValor_fatura() {
        return valor_fatura;
    }
    public void setValor_fatura(double valor_fatura) {
        this.valor_fatura = valor_fatura;
    } 
}
