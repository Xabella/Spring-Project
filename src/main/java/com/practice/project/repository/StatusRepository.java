package com.practice.project.repository;

import com.practice.project.model.StatusModel;
import com.practice.project.model.SubscriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusModel, Long> {
}
