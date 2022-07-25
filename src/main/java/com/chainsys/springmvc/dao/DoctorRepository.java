package com.chainsys.springmvc.dao;

import java.util.List;
import com.chainsys.springmvc.pojo.Doctor;
import org.springframework.data.repository.CrudRepository;
public interface DoctorRepository extends CrudRepository<Doctor,Integer> {
    Doctor findById(int id);
    Doctor save(Doctor dr);
    // Used for adding new doctor
    void deleteById(int id);
    List<Doctor> findAll();
}
