package com.cybage.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cybage.dao.ComplaintRepository;
import com.cybage.model.Complaint;
import com.cybage.model.Food;

@RunWith(SpringRunner.class)
@SpringBootTest
class ComplaintServiceTest {
	
	@Autowired
	private ComplaintService complaintService;
	
	@MockBean
	private ComplaintRepository complaintRepository;

	@Test
	void testAddComplaint() {
		Complaint complaint=new Complaint(1,"good food","unresolved","may","april",2);
		Mockito.when(complaintRepository.save(complaint)).thenReturn(complaint);
		assertThat(complaint.getId()==1);
		assertThat(complaint !=null);
	}

//	@Test
//	void testGetComplaintByRestOwnerId() {
//		fail("Not yet implemented");
//	}

}
