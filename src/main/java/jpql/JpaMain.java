package jpql;

import hello.Member;
import hello.Team;
import jpql.entity.*;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

	public static void main(String[] args) {
		// persistence.xml파일에 unit name="hello" 매핑 필요
		// Databse 1개당 1개만 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// 고객에 요청마다 사용 -> 쓰레드간의 공유 X
		EntityManager em = emf.createEntityManager();
		// JPA의 모든 데이터 변경은 트랜잭션 안에서 실행됨
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {

			JpqlTeam team = new JpqlTeam();
			team.setName("Team1");
			em.persist(team);

			for (int i = 0; i< 10 ; i++) {
				JpqlMember member = new JpqlMember();

				member.setAge(1 + i);
				member.setUsername("member"+ i);
				if (i >= 5) {
					member.chageTeam(team);

					member.setType(MemberType.USER);
				} else {
					member.setType(MemberType.ADMIN);
				}
				em.persist(member);
			}

			em.flush();
			em.clear();

			List<Object[]> resultList =
				 em.createQuery("select 'a' || 'b', m.age from JPQL_MEMBER m")
				.getResultList();

			for (Object[] objects : resultList) {
				System.out.println(" objects : " + objects[0] + ", " + objects[1]);
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			// 엔티티 매니저가 트랜잭션을 사용하기때문에 꼭 닫아줘야함.
			em.close();
		}

		// WAS가 내려갈때 엔티티매니저팩토리는 닫아줘야 함 그래야지 커넥션풀링이나 리소스가 릴리즈가 됨
		emf.close();
	}

}
