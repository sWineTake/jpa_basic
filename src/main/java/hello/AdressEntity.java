package hello;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ADRESS")
@NoArgsConstructor
public class AdressEntity {
	@Id @GeneratedValue
	@Column(name = "ADRESS_ID")
	private Long id;

	private Adress adress;
	public AdressEntity(String c, String s, String z) {
		this.adress = new Adress(c, s, z);
	}
}
