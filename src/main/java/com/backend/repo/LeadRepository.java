package com.backend.repo;

import com.backend.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    
    @Query("SELECT l FROM Lead l WHERE " +
           "LOWER(l.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
           "LOWER(l.email) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Lead> searchByNameOrEmail(@Param("search") String search);
    
    Optional<Lead> findByEmail(String email);
}