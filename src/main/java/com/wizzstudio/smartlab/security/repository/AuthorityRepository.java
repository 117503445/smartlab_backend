package com.wizzstudio.smartlab.security.repository;

import com.wizzstudio.smartlab.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
@RepositoryRestResource(exported = false)
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
