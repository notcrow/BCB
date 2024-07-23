package BCB.BCB.dtos;

public class ClienteDTO {
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
        this.Nome = nome;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }
    public String getTelefone() {
        return Telefone;
    }
    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }
    public String getCPF_pessoa() {
        return CPF_pessoa;
    }
    public void setCPF_pessoa(String cPF_pessoa) {
        this.CPF_pessoa = cPF_pessoa;
    }
    public String getCNPJ() {
        return CNPJ;
    }
    public void setCNPJ(String cNPJ) {
        this.CNPJ = cNPJ;
    }
    public String getEmpresa() {
        return Empresa;
    }
    public void setEmpresa(String empresa) {
        this.Empresa = empresa;
    }
}
