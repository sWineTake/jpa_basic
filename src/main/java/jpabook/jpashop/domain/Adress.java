package jpabook.jpashop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
		return  Objects.equals(getCity(), adress.getCity()) &&
				Objects.equals(getStreet(), adress.getStreet()) &&
				Objects.equals(getZipcode(), adress.getZipcode());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCity(), getStreet(), getZipcode());
	}
}
