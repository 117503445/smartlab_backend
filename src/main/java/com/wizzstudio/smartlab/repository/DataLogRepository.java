package com.wizzstudio.smartlab.repository;

import com.wizzstudio.smartlab.entity.DataLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "BehaviorLog", path = "BehaviorLog")
@RepositoryRestResource(exported = false)
public interface DataLogRepository extends JpaRepository<DataLogEntity, Integer> {
}
