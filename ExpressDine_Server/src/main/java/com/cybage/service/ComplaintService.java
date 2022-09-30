package com.cybage.service;

import java.util.List;

import com.cybage.model.Complaint;

public interface ComplaintService {
	
	void addComplaint(Complaint complaint);

	List<Complaint> getComplaintByRestOwnerId(int id);

	void resolveComplaint(int id);

	List<Complaint> getComplaintsByUser(int id);

}
