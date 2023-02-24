package com.niemannproject.digitalpersonalorganizer.models.data;

import com.niemannproject.digitalpersonalorganizer.models.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Integer> {
}
