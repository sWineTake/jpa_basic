package hello;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // JPA를 사용하기위해 무조건 필수
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	@Id // PK
	private Long id;
	private String name;
}
