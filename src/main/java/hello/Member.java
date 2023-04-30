package hello;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member extends BaseEntity{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID")
	private Team team;

	public Member() {
	}
}
