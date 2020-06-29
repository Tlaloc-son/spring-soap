package pokemon.api.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Log {

	@Id
	@GeneratedValue
	private Long id;
	private String resource;
	private String ip;
	private Long took;
	private LocalDateTime date;
}
