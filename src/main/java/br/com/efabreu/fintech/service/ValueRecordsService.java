package br.com.efabreu.fintech.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.efabreu.fintech.repository.ValueRecordsRepository;
import br.com.efabreu.fintech.dto.ValueRecordsDTO;
import br.com.efabreu.fintech.model.Users;
import br.com.efabreu.fintech.model.ValueRecords;

@Service
public class ValueRecordsService {
	
	@Autowired
	ValueRecordsRepository recordRepository;
	
	public List<ValueRecords> registrosAno(Date date, Users user){
		
		List<ValueRecords> listaRegistros = recordRepository.findByData(date);
		return listaRegistros;		
		
	}
	
	public void saveRecord(String valor, boolean tipo, String descricao, Date data, Long userId) {
		
		ValueRecords registro = new ValueRecords(userId, descricao, tipo, valor, data);
		recordRepository.save(registro);
		
	}
	
	public void deleteById(Long recordId) {
		
		recordRepository.deleteById(recordId);
	}
	
	public ValueRecords findRecordById(Long recordId) {
		ValueRecords vr = recordRepository.findById(recordId).orElseThrow();
		return vr;
	}

	public ValueRecords getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(ValueRecordsDTO registroDTO) {
		ValueRecords registro = registroDTO.toObject();
		recordRepository.save(registro);
		
	}

	public boolean update(ValueRecordsDTO registroDTO, Long id) {
		ValueRecords registro = registroDTO.toObject();
		if (!recordRepository.existsById(id)) {
			return false;
		};
		registro.setValueId(id);
		recordRepository.save(registro);
		return true;
	}	
	
	

}
