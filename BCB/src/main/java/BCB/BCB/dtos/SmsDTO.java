package BCB.BCB.dtos;

public class SmsDTO {
    private long Id_sms;
    private String telefone;
    private boolean whatsapp;
    private String texto;
    
    public long getId_sms() {
        return Id_sms;
    }
    public void setId_sms(long id_sms) {
        Id_sms = id_sms;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public boolean isWhatsapp() {
        return whatsapp;
    }
    public void setWhatsapp(boolean whatsapp) {
        this.whatsapp = whatsapp;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
}
