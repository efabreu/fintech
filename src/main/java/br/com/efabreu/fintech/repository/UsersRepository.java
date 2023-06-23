package br.com.efabreu.fintech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.efabreu.fintech.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
