package com.wizzstudio.smartlab.repository;

import com.wizzstudio.smartlab.entity.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "feedback", path = "feedback")
public interface FeedBackRepository extends CrudRepository<Feedback, Integer> {
}
