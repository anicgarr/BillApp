package org.ang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.ang.BillController;

@Component
@Repository
public interface BillRepository extends CrudRepository <Bill, Long> {

    List<Bill> findByCreditorName(String creditorName); 

	}
	

