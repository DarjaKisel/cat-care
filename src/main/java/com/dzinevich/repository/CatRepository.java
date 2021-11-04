package com.dzinevich.repository;

import com.dzinevich.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
