package com.sat.webd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sat.webd.models.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // You can define custom queries or methods here if needed
}
