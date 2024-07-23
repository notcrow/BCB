package BCB.BCB.controller;

import BCB.BCB.model.Sms;
import BCB.BCB.service.SmsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SmsController {
    @Autowired
    private SmsService smsService;

    @PostMapping("/enviar")
    public String enviarSms(@RequestBody Sms smsSolicitado) {
        smsService.enviarSms(smsSolicitado.getId_sms(), smsSolicitado.getTelefone(), smsSolicitado.getTexto());
        return "Mandagem enviada";
    }
}