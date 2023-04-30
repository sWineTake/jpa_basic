package hello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Adress {
	private String city;
	private String street;
	private String zipcode;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Adress adress = (Adress) o;
		return Objects.equals(city, adress.city) &&
				Objects.equals(street, adress.street) &&
				Objects.equals(zipcode, adress.zipcode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, street, zipcode);
	}
}
