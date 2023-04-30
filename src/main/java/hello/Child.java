package hello;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Child {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CHILD_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private Parent parent;

}
