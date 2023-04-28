package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CategoryItem extends TBaseEntity{

	@Id @GeneratedValue
	@Column(name = "CATEGORY_ITEM_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID")
	private Items item;


}
