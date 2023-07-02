package br.com.efabreu.fintech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.efabreu.fintech.dto.ValueRecordsDTO;
import br.com.efabreu.fintech.model.ValueRecords;
import br.com.efabreu.fintech.service.ValueRecordsService;

@RestController
@RequestMapping("/vrecords")
public class ValueRecordsController {
	
	@Autowired
	ValueRecordsService valueRecordsService;
		
	@GetMapping (value = "/{id}")
	public ResponseEntity<?> buscarRegistroPorId(@RequestParam Long id) {
		ValueRecords registro = valueRecordsService.findRecordById(id);
		return ResponseEntity.ok(registro);
	}
	
	
	@PostMapping(value = "/")
	public ResponseEntity<String> criarRegistro(@RequestBody ValueRecordsDTO registroDTO) {
		valueRecordsService.create(registroDTO);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Registro criado com sucesso.");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> atualizarRegistro(@RequestBody ValueRecordsDTO registroDTO, @PathVariable Long id) {
		if(!valueRecordsService.update(registroDTO, id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		};		
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Object> remove(@PathVariable Long id) {
		valueRecordsService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping (value = "/MeusRegistros")
	public ResponseEntity<?> buscarRegistrosPorUserId(@RequestParam Long userId) {
		List<ValueRecords> registro = valueRecordsService.findAllRecordsByUserId(userId);
		return ResponseEntity.ok(registro);
	}
}
