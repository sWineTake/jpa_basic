package hello;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Team {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEAM_ID")
	private Long id;
	private String name;

	@OneToMany(mappedBy = "team") // 1:N 매핑에서, Member입장에서 매핑된 변수명을 적어주시면됩니다.
	private List<Member> members = new ArrayList<>();

	public void addMember(Member member) {
		this.members.add(member);
		member.setTeam(this);
	}
}
