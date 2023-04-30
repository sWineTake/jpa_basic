package hello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Period {

	private LocalDateTime startDate;
	private LocalDateTime endDate;

}
