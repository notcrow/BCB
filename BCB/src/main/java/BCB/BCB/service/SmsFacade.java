package BCB.BCB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BCB.BCB.dtos.SmsDTO;
import BCB.BCB.model.Sms;
import BCB.BCB.repository.SmsRepository;

@Service
public class SmsFacade {
    @Autowired
    private SmsRepository smsRepository;

    public SmsDTO criar (SmsDTO smsDTO){
        Sms sms = new Sms();
        sms.setTelefone(smsDTO.getTelefone());
        sms.setTexto(smsDTO.getTexto());
        sms.setWhatsapp(smsDTO.isWhatsapp());
        smsRepository.save(sms);
        smsDTO.setId_sms(sms.getId_sms());
        return smsDTO;
    }

}
