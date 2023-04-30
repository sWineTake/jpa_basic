package hello;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Member {
	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Embedded
	private Adress homeAdress;

	@ElementCollection
	@CollectionTable(name = "FAVORITE_FOOD",
			joinColumns = @JoinColumn(name = "MEMBER_ID"))
	@Column(name = "FOOD_NAME")
	private Set<String> favoritFoods = new HashSet<>();

//	@ElementCollection
//	@CollectionTable(name = "ADRESS",
//			joinColumns = @JoinColumn(name = "MEMBER_ID"))
//	private List<Adress> adressHistory = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MEMBER_ID")
	private List<AdressEntity> adressHistory = new ArrayList<>();


}
