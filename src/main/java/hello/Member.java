package hello;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Member extends BaseEntity{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_ID")
	private Long id;

	@Column(name = "USERNAME")
	private String username;

	// @OneToOne
	// @JoinColumn(name = "LOCKER_ID")
	@OneToOne(mappedBy = "member")
	private Locker locker;

	@OneToMany(mappedBy = "members")
	private List<MemberProduct> memberProduct = new ArrayList<>();

	public Member() {
	}
}
