package BCB.BCB.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BCB.BCB.dtos.SaldoDTO;
import BCB.BCB.model.Saldo;
import BCB.BCB.repository.SaldoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SaldoFacade {

    @Autowired
    private SaldoRepository saldoRepository;

    public SaldoDTO atualiza(SaldoDTO saldoDTO, long clienteID, double valorSaldo){
        Optional<Saldo> optionalSaldo = saldoRepository.findById(clienteID);
        if (optionalSaldo.isPresent()) {
            Saldo saldo = optionalSaldo.get();
            saldo.setId_cliente(clienteID);
            saldo.setId_recarga(saldoDTO.getId_recarga());
            saldo.setId_sms(saldoDTO.getId_sms());
            saldo.setStatus(saldoDTO.isStatus());
            saldo.setValor_saldo(valorSaldo);
            saldoRepository.save(saldo);
            return saldoDTO;
        } else {
            throw new EntityNotFoundException("Cliente não encontrado com id: " + clienteID);
        }
    }

}
