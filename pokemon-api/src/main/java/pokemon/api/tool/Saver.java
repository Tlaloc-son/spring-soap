package pokemon.api.tool;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import pokemon.api.entity.Notification;
import pokemon.api.service.NotificationService;

@Configuration
@EnableScheduling
public class Saver {

	public static final Log LOGGER = LogFactory.getLog(Saver.class);
	
	public static Queue<String> notifications = new LinkedList<String>();
	
	@Autowired
	private NotificationService notificationService;
	
	@Scheduled(cron = "* * * * * *")
	public void dataExtractor() {
		while (!notifications.isEmpty()) {
			Notification notification = notificationService.save(notifications.poll());
			LOGGER.info(String.format("Notification saves [%d]", notification.getId()));
		}
		LOGGER.info("EMPTY");
	} 
}
