package pokemon.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Notification {

	@Id
	@GeneratedValue
	private Long id;
	private String body;
	private int status;
	private String description;
	private LocalDateTime date;
}
