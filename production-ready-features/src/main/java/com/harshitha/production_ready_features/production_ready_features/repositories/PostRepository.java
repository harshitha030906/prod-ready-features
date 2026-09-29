package com.harshitha.production_ready_features.production_ready_features.repositories;

import com.harshitha.production_ready_features.production_ready_features.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
