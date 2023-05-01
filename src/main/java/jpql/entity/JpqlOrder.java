package jpql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "JPQL_ORDER")
@Table(name = "JPQL_ORDER")
public class JpqlOrder {

	@Id @GeneratedValue
	@Column(name = "ORDER_ID")
	private Long id;

	@Column(name = "ORDRE_AMOUNT")
	private int orderAmount;

	@Embedded
	private JpqlAdress adress;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private JpqlProduct product;

}
