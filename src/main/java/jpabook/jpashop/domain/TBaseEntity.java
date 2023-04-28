package jpabook.jpashop.domain;


import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class TBaseEntity {
	private LocalDateTime createDate;
	private LocalDateTime lastModifiedDate;
}
