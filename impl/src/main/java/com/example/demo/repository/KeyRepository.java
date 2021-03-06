package com.example.demo.repository;

import com.example.demo.model.KeySet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface KeyRepository extends JpaRepository<KeySet, String>{
    @Query("select keyset from KeySet keyset where keyset.createdBy.id = ?1")
    Page<KeySet> findAllByCreatedBy_Id(String userId, Pageable pageable);
}
