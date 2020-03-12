package com.hnsic.jpa.respository;

import com.hnsic.jpa.entity.po.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRespository extends JpaRepository<Admin, Integer> {
}
