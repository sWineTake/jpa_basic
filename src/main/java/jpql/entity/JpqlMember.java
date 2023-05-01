package jpql.entity;

import hello.Team;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "JPQL_MEMBER")
@Table(name = "JPQL_MEMBER")
public class JpqlMember {

	@Id @GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "AGE")
	private int age;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private JpqlTeam team;

	@Enumerated(EnumType.STRING)
	private MemberType type;

	public void chageTeam(JpqlTeam team) {
		team.getMembers().add(this);
		this.team = team;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
