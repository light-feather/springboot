package com.charis.springboot.dao;

import com.charis.springboot.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category,Integer> {
    List<Category> findByName(String name);

    List<Category> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name,
                                                                int id);
}
