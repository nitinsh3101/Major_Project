package com.cybage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

	Login getByUserId(int userId);

}
