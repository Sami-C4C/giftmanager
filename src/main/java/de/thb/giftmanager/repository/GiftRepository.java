package de.thb.giftmanager.repository;

import de.thb.giftmanager.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;




@RepositoryDefinition(domainClass = Gift.class, idClass = Long.class)
public interface GiftRepository extends JpaRepository<Gift,Long> {
}
