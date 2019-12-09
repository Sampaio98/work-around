package com.study.workaround.domain.repository;

import com.study.workaround.config.DBConfig;
import com.study.workaround.domain.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    @Query(nativeQuery = true, value = "select * from " + DBConfig.SCHEMA  + "party where id = ?1")
    Optional<Party> findPartyLoka(Long id);

    Optional<Party> findByTitle(String name);
}
