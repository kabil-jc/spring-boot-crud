package com.example.spring_boot_demo.repositry;

import com.example.spring_boot_demo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositry  extends JpaRepository<UserEntity,Long> {
}
