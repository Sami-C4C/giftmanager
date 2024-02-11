package de.thb.giftmanager.repository;

import de.thb.giftmanager.entity.GiftList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@RepositoryDefinition(domainClass = GiftList.class, idClass = Long.class)
public interface GiftListRepository extends CrudRepository<GiftList, Long> {


    // List<GiftList> findAllByTitle(String title);

}
