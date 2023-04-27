package hello;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
// @Entity
public class Member {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

// @Column(name = "TEAM_ID")
// private Long teamId;
	@ManyToOne // 회원은 N이고 팀은 1이기 때문
	@JoinColumn(name = "TEAM_ID") // 연결할 컬럼명
	private Team team;

	public Member() {
	}

	public void chageTeam(Team team) {
		this.team = team;
		team.getMembers().add(this);
	}
}
