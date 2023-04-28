package hello;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class MemberProduct {

	@Id @GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private Member members;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product products;

}
