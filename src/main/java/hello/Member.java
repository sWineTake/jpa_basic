package hello;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Member {

	@Id // PK 매핑
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 방언에 따라 자동 지정, 기본값
	private Long id;

	@Column(name = "name") // DB컬럼명은 name
	private String username;

	public Member() {
	}
}
