package hello;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 조인전략
@DiscriminatorColumn(name = "DIS_TYPE")
@Setter
@Getter
public abstract class Item {
	@Id @GeneratedValue
	private Long id;
	private String name;
	private int price;
}
