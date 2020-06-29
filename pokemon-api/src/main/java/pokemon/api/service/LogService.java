package pokemon.api.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import pokemon.api.entity.Log;
import pokemon.api.repository.LogRepository;

@Service
public class LogService {

	private LogRepository logRepository;
	
	public LogService(LogRepository logRepository) {
		this.logRepository = logRepository;
	}
	
	public Log save(String ip, String resource, Long took) {
		Log log = new Log();
		log.setIp(ip);
		log.setResource(resource);
		log.setTook(took);
		log.setDate(LocalDateTime.now());		
		return logRepository.save(log);
	}
}
