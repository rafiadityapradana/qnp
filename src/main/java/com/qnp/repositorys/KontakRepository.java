package com.qnp.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qnp.entitys.KontakEntity;

@Repository
public interface KontakRepository extends JpaRepository<KontakEntity, UUID> {
}