package jpql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "JPQL_PRODUCT")
@Table(name = "JPQL_PRODUCT")
public class JpqlProduct {

	@Id @GeneratedValue
	@Column(name = "PRODUCT_ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "PRICE")
	private int price;

	@Column(name = "STOCK_AMOUNT")
	private int stockAmount;

}
