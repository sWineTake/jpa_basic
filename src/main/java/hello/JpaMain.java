package hello;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

	public static void main(String[] args) {
		// persistence.xml파일에 unit name="hello" 매핑 필요
		// Databse 1개당 1개만 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		// 고객에 요청마다 사용 -> 쓰레간의 공유 X
		EntityManager em = emf.createEntityManager();
		// JPA의 모든 데이터 변경은 트랜잭션 안에서 실행됨
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			// INSERT START
			/*
			Member member = new Member();
			member.setId(2L);
			member.setName("HelloB");
			em.persist(member);
			*/

			// SELECT & UPDATE
			/*
			Member member = em.find(Member.class, 1L);
			member.setName("Hello AA");
			*/

			// ex ) JPQL의 경우 From절에 사용된 테이블명이 실제 Java 객체와 매핑됨
			// 기본 AnsiQuery는 모두 사용 가능
			List<Member> selectMFromMember = em.createQuery("select m from Member as m", Member.class)
					.setFirstResult(1)
					.setMaxResults(10)
					.getResultList();

			for (Member member : selectMFromMember) {
				System.out.println("member Name : " + member.getName());
			}
			// 커밋을 하지않을경우, 모든 변경사항은 반영되지 않음
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			// 엔티티 매니저가 트랜잭션을 사용하기때문에 꼭 닫아줘야함.
			em.close();
		}

		// WAS가 내려갈때 엔티티매니저팩토리는 닫아줘야 함 그래야지 커넥션풀링이나 리소스가 릴리즈가 됨
		emf.close();
	}

}
