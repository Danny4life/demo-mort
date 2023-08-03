package com.osiki.mortuarydemo.repository;

import com.osiki.mortuarydemo.model.Body;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BodyRepository extends JpaRepository<Body, Long> {
}
