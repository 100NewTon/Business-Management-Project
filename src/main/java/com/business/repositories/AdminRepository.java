package com.business.repositories;

import org.springframework.data.repository.CrudRepository;

import com.business.entities.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>
{
	public Admin findByAdminEmail(String email);
}
