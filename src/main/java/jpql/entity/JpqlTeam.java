package jpql.entity;

import hello.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "JPQL_TEAM")
@Table(name = "JPQL_TEAM")
public class JpqlTeam {

	@Id
	@GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "team")
	private List<JpqlMember> members = new ArrayList<>();

}
