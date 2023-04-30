package hello;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Parent {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PARENT_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Child> childList = new ArrayList<>();

	public void addChild(Child child) {
		this.childList.add(child);
		child.setParent(this);
	}

}
