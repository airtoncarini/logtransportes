package br.com.logtransportes.controle_viagem.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.logtransportes.controle_viagem.controller.dto.HoraExtraDto;
import br.com.logtransportes.controle_viagem.modelo.Motorista;
import br.com.logtransportes.controle_viagem.modelo.Viagem;
import br.com.logtransportes.controle_viagem.repository.MotoristaRepository;
import br.com.logtransportes.controle_viagem.repository.ViagemRepository;

@RestController
@RequestMapping("/hora_extra")
public class HoraExtraController {

	private long total;
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	@GetMapping
	public HoraExtraDto calcHoraExtra(@RequestParam Long idMotorista,@RequestParam int ano,@RequestParam int mes) {
		
		Motorista motorista = motoristaRepository.getById(idMotorista);
		
		/*
		 * Considerando que o motorista trabalha das 8h as 18h, com 1 hora de almoço,
		 * então são 9 horas por dia ou 45 horas semanais.
		 * De acordo com a legislação vigente, a carga horária mensal é de 225 horas.
		 */
		Double valorHora = motorista.getSalario() / 225 * 1.3;
				
		LocalDateTime dh1 = YearMonth.of(ano,mes).atDay(1).atTime(0,0,0);
		LocalDateTime dh2 = YearMonth.of(ano,mes).atEndOfMonth().atTime(23,59,59);
		
		List<Viagem> viagens = viagemRepository.findAllByMotorista_idAndDhSaidaBetween(idMotorista,dh1,dh2);
		viagens.forEach(viagem -> {
			LocalDateTime dhReferenciaEntrada = LocalDateTime.of(viagem.getDhSaida().getYear(),viagem.getDhSaida().getMonthValue(),viagem.getDhSaida().getDayOfMonth(),8,0,0);
			LocalDateTime dhReferenciaSaida = LocalDateTime.of(viagem.getDhSaida().getYear(),viagem.getDhSaida().getMonthValue(),viagem.getDhSaida().getDayOfMonth(),18,0,0);
			
			Duration duration;
			
			duration = Duration.between(viagem.getDhSaida(), dhReferenciaEntrada);
			if (duration.getSeconds() > 0)
				total += duration.getSeconds();
			
			duration = Duration.between(dhReferenciaSaida,viagem.getDhChegada());
			if (duration.getSeconds() > 0)
				total += duration.getSeconds();
		});
		System.out.println(total);
		total = total / 3600;
		System.out.println(total);
		
		Double vlHorasExtras = total * valorHora;
		
		HoraExtraDto horaextra = new HoraExtraDto();
		horaextra.setId(motorista.getId());
		horaextra.setNome(motorista.getNome());
		horaextra.setSalario(motorista.getSalario());
		horaextra.setValorHorasExtras(vlHorasExtras);
		horaextra.setSalarioTotal(motorista.getSalario() + vlHorasExtras);
		
		return horaextra;
	}
}
