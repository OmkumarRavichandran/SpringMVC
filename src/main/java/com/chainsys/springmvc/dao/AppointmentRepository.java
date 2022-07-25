package com.chainsys.springmvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.Doctor;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

	Appointment findById(int id);

	Appointment save(Appointment dr);

	// Used for adding new doctor
	void deleteById(int id);

	List<Appointment> findAll();
	// Define a native query for this method
//	int getNextId();
}
