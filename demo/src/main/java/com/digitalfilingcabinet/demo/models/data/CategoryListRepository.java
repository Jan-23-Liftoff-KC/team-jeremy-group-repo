package com.digitalfilingcabinet.demo.models.data;

import com.digitalfilingcabinet.demo.models.CategoryList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryListRepository extends CrudRepository<CategoryList, Integer> {
    // these things extend the CrudRepository built in thing.

}
