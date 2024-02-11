package de.thb.giftmanager.repository;

import de.thb.giftmanager.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import java.util.List;



// As long as we deleted Giftpool Class, is it necessary to have GiftPoolRepository ?

@RepositoryDefinition(domainClass = Gift.class, idClass = Long.class)
public interface GiftRepository extends CrudRepository<Gift,Long> {


}
