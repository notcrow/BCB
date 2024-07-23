package BCB.BCB.Clientes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BCB.BCB.repository.FaturaRepository;
import BCB.BCB.service.FaturaFacade;
import BCB.BCB.dtos.FaturaDTO;
import BCB.BCB.model.Fatura;

@Service        
public class CalculaFatura {
    
    @Autowired
    private FaturaRepository faturaRepository;
    @Autowired
    private FaturaFacade faturaFacade;
    
    double CUSTO_SMS = 0.25;
    double faturaCliente = 0;

    public String calculaFatura (Long clienteID) {
        Optional<Fatura> optionalFatura = faturaRepository.findById(clienteID);
        if (optionalFatura.isPresent()) {
            Fatura fatura = optionalFatura.get();
            if (fatura.getValor_fatura() >= CUSTO_SMS) {
                
                FaturaDTO faturaDTO = new FaturaDTO();
                faturaDTO.setId_cliente(fatura.getId_cliente());
                faturaDTO.setId_fatura(fatura.getId_fatura());
                faturaDTO.setId_movto(fatura.getId_movto());
                faturaDTO.setId_sms(fatura.getId_sms());
                faturaDTO.setValor(fatura.getValor());
                faturaDTO.setValor(fatura.getValor_anterior());
                faturaDTO.setValor_fatura(fatura.getValor_anterior());
                
                faturaCliente = fatura.getValor_fatura() + CUSTO_SMS;
                faturaFacade.atualiza(faturaDTO, clienteID, faturaCliente);
            } else {
                throw new UnsupportedOperationException("Saldo insuficiente");
            }
        } else {
            return "Fatura nao encontrada, id fatura: " + clienteID ;
        }
        return "Calculado fatura";
    }
}