package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Category extends TBaseEntity{
	@Id @GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Long id;
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private Category parent;

	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<>();

	@OneToMany(mappedBy = "category")
	private List<CategoryItem> categoryItems = new ArrayList<>();
}
