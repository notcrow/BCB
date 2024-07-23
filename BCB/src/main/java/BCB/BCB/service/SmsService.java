package BCB.BCB.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BCB.BCB.Clientes.CalculaFatura;
import BCB.BCB.Clientes.CalculaSaldo;
import BCB.BCB.dtos.SmsDTO;
import BCB.BCB.model.Cliente;
import BCB.BCB.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SmsService {

    @Autowired
    private ClienteRepository clienteRepository;
    private CalculaSaldo calculaSaldo;
    private CalculaFatura calculaFatura;
    private SmsFacade smsFacade;

    public String enviarSms(Long clienteId, String telefoneDestino, String mensagem) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(clienteId);
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            if (cliente.getTipo_plano().equalsIgnoreCase("PRE")) {
                calculaSaldo.calculaCusto(clienteId);
            } else if (cliente.getTipo_plano().equalsIgnoreCase("POS")) {
                calculaFatura.calculaFatura(clienteId);
            } else {
                throw new RuntimeException("Tipo de plano invalido");
            }

            SmsDTO smsDTO = new SmsDTO();
            smsDTO.setTelefone(telefoneDestino);
            smsDTO.setTexto(mensagem);
            smsDTO.setWhatsapp(true);
            smsFacade.criar(smsDTO);
            return "sms criado";
        } else {
            throw new EntityNotFoundException("Cliente nao encontrado com id: " + clienteId);
        }
    }
}
