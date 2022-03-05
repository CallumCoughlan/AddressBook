package com.addressBook.AddressBook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buddy", path = "buddy")
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(@Param("name") String name);

    List<BuddyInfo> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    List<BuddyInfo> findAll();

    List<BuddyInfo> removeBuddyInfoById(@Param("bid") long bid);

    BuddyInfo findById(@Param("bid") long bid);
}
