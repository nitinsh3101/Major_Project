package com.cybage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{


}
