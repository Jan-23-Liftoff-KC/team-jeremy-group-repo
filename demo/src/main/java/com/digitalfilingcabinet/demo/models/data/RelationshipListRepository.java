package com.digitalfilingcabinet.demo.models.data;

import com.digitalfilingcabinet.demo.models.Relationship;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipListRepository extends CrudRepository <Relationship, Integer> {
    // these things extend the CrudRepository built in thing.

}
