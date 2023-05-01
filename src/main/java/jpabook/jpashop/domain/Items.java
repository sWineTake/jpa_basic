package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Items extends TBaseEntity{

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEM_ID")
	private Long id;
	private String name;
	private int price;
	private int stockQuantitiy;

	@OneToMany(mappedBy = "item")
	private List<CategoryItem> categoryItems = new ArrayList<>();
}


