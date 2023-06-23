package br.com.efabreu.fintech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.efabreu.fintech.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository authRepository;
	
	

}
