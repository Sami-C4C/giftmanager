package de.thb.giftmanager.repository;

import de.thb.giftmanager.entity.GiftList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;



@RepositoryDefinition(domainClass = GiftList.class, idClass = Long.class)
public interface GiftListRepository extends JpaRepository<GiftList, Long> {

}
