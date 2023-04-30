package hello;

import org.hibernate.Hibernate;

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
			Child child1 = new Child();
			Child child2 = new Child();

			Parent parent = new Parent();
			parent.addChild(child1);
			parent.addChild(child2);

			em.persist(parent);
			em.flush();
			em.clear();

			Parent findParent = em.find(Parent.class, parent.getId());
			em.remove(findParent);

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
