package BCB.BCB.Clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BCB.BCB.repository.SaldoRepository;
import BCB.BCB.service.SaldoFacade;
import BCB.BCB.dtos.SaldoDTO;
import BCB.BCB.model.Saldo;

@Service        
public class CalculaSaldo {
    
    @Autowired
    private SaldoRepository saldoRepository;
    private SaldoFacade saldoFacade;
    
    private static final double CUSTO_SMS = 0.25;
    private double saldoCliente = 0;

    public String calculaCusto (Long clienteID) {

        Saldo saldo = saldoRepository.findById(clienteID)
                    .orElseThrow(() -> new RuntimeException("Saldo nao encontrado"));
        if (saldo.getValor_saldo() >= CUSTO_SMS) {
            SaldoDTO saldoDTO = new SaldoDTO();
            saldoCliente = saldo.getValor_saldo() - CUSTO_SMS;
            saldoFacade.atualiza(saldoDTO, clienteID, saldoCliente);
            return "saldo calculado";
        } else {
            throw new UnsupportedOperationException("Saldo insuficiente");
        }
    }
}


