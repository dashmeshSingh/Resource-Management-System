package com.codekul.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codekul.entities.Invoice;

@Repository
public interface InvoiceRepository  extends JpaRepository<Invoice, Integer> {
	
	@Query(value="select * from invoice where project_name=:projname",nativeQuery=true)
	List<Invoice> findInvoiceDetailsByProjId(String projname);

}
