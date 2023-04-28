package hello;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Product {
	@Id @GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long id;

	private String name;

	@OneToMany(mappedBy = "products")
	private List<MemberProduct> memberProduct = new ArrayList<>();
}
