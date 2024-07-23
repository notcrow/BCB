package BCB.BCB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_cliente;
    private String Nome;
    private String Email;
    private String Telefone;
    private String CPF_pessoa;
    private String CNPJ;
    private String Empresa;
    private String tipo_plano;
    
    public String getTipo_plano() {
        return tipo_plano;
    }
    public void setTipo_plano(String tipo_plano) {
        this.tipo_plano = tipo_plano;
    }
    public Long getId() {
        return Id_cliente;
    }
    public void setId(Long Id_cliente) {
        this.Id_cliente = Id_cliente;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getTelefone() {
        return Telefone;
    }
    public void setTelefone(String telefone) {
        Telefone = telefone;
    }
    public String getCPF_pessoa() {
        return CPF_pessoa;
    }
    public void setCPF_pessoa(String cPF_pessoa) {
        CPF_pessoa = cPF_pessoa;
    }
    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
    }
    public String getEmpresa() {
        return Empresa;
    }
    public void setEmpresa(String empresa) {
        Empresa = empresa;
    }
    
}
