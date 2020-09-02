package com.wizzstudio.smartlab.repository;

import com.wizzstudio.smartlab.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "feedback", path = "feedback")
@RepositoryRestResource(exported = false)
public interface FeedBackRepository extends JpaRepository<FeedbackEntity, Integer> {

}
