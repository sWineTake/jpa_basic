package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Members extends TBaseEntity{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_ID")
	private Long id;
	private String name;

	@Embedded
	private Adress adress;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();
}
