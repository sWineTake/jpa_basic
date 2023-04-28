package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CategoryItem {

	@Id @GeneratedValue
	@Column(name = "CATEGORY_ITEM_ID")
	private Long id;

	@OneToMany
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;

	@OneToMany
	@JoinColumn(name = "ITEM_ID")
	private Item item;


}
