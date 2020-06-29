package pokemon.api.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import pokemon.api.entity.Notification;
import pokemon.api.repository.NotificationRepository;

@Service
public class NotificationService {

	private NotificationRepository notificationRepository;
	
	public NotificationService(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}
	
	public Notification save(String body) {
		Notification notification = new Notification();
		notification.setStatus(0);
		notification.setBody(body);
		notification.setDescription("Ready to process");
		notification.setDate(LocalDateTime.now());
		return notificationRepository.save(notification);
	}
}
