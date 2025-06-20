package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.SiteUser;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {

}
