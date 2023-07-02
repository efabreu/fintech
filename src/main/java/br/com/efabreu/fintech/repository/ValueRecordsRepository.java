package br.com.efabreu.fintech.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.efabreu.fintech.model.ValueRecords;

public interface ValueRecordsRepository extends JpaRepository<ValueRecords, Long> {

	List<ValueRecords> findByData(Date data);

	@Query(value = "SELECT * FROM VALUE_RECORDS WHERE USER_ID = :id ",
			nativeQuery = true)
	List<ValueRecords> buscarMeusRegistros(@Param("id")Long id);
	
//	@Query(value = "SELECT T1.*, '' AS userId FROM RECORD T1 WHERE USER = :userId AND DATE > inicio AND DATE < fim",
//			nativeQuery = true)
//	List<Record> findByUserAndYear(@Param("userId")Long userId, @Param("inicio")Date ini, @Param("fim")Date fin);
	

}
