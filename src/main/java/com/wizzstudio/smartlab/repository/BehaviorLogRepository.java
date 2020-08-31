package com.wizzstudio.smartlab.repository;

import com.wizzstudio.smartlab.entity.BehaviorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "BehaviorLog", path = "BehaviorLog")
public interface BehaviorLogRepository extends JpaRepository<BehaviorLog, Integer> {
}
