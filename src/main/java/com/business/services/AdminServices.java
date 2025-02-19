package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.business.entities.Admin;
import com.business.repositories.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServices
{
	@Autowired
	private AdminRepository adminRepository;
	
	//Get All Admins
	public List<Admin>getAll()
	{
		 List<Admin> admins = (List<Admin>)this.adminRepository.findAll();
		 return admins;
	}
	//Get Single Admin
	public Admin getAdmin(int id)
	{
		Optional<Admin> optional = this.adminRepository.findById(id);
		Admin admin=optional.get();
		return admin;
	}
//Update Admin
	public void update(Admin admin ,int id)
	{
		admin.setAdminId(id);
		this.adminRepository.save(admin);
	}
	
	//delete User
	public void delete(int id)
	{
		this.adminRepository.deleteById(id);
	}
	
	//add Admin
	public void addAdmin(Admin admin)
	{
		this.adminRepository.save(admin);
	}
	
	//Validating Admin login
	public boolean validateAdminCredentials(String email,String password)
	{
		Admin admin=adminRepository.findByAdminEmail(email);
		if(admin!=null && admin.getAdminPassword().equals(password))
		{
			return true;
		}
		return false;
	}
}
