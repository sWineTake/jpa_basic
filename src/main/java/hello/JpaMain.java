package hello;

import javax.persistence.*;

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

			Member member = new Member();
			member.setUsername("member1");
			member.setHomeAdress(new Adress("city1", "street1", "zipcode1"));
			member.getFavoritFoods().add("치킨");
			member.getFavoritFoods().add("족발");
			member.getFavoritFoods().add("피자");
			member.getAdressHistory().add(new AdressEntity("old1", "old1", "old1"));
			member.getAdressHistory().add(new AdressEntity("old2", "old2", "old2"));


			em.persist(member);
			em.flush();
			em.clear();

			System.out.println("==========================================");
			Member findMember = em.find(Member.class, member.getId());


			// Adress에 equals가 오버라이딩이 되어있다는 가정하에 remove가 정상작동 됨




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
