package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Delivery extends TBaseEntity{

	@Id @GeneratedValue
	@Column(name = "DELIVERY_ID")
	private Long id;

	@OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
	private Order order;

	@Enumerated
	private Adress adress;

	@Enumerated(EnumType.STRING)
	private DeliveryStatus deliveryStatus;

}
