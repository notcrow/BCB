package BCB.BCB.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BCB.BCB.dtos.FaturaDTO;
import BCB.BCB.model.Fatura;
import BCB.BCB.repository.FaturaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FaturaFacade {

    @Autowired
    private FaturaRepository faturaRepository;

    public FaturaDTO atualiza(FaturaDTO faturaDTO, long clienteID, double valorSaldo){
        Optional<Fatura> optionalSaldo = faturaRepository.findById(clienteID);
        if (optionalSaldo.isPresent()) {
            Fatura fatura = optionalSaldo.get();
            fatura.setId_cliente(clienteID);
            fatura.setValor_fatura(valorSaldo);
            faturaRepository.save(fatura);
            return faturaDTO;
        } else {
            throw new EntityNotFoundException("Cliente não encontrado com id: " + clienteID);
        }
    }
}