package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.AdminModel;
import com.example.demo.Model.LoanApplicationModel;
import com.example.demo.Model.LoginModel;
import com.example.demo.Model.UserModel;

import com.example.demo.Service.LoanService;

@CrossOrigin("*")
@RestController

public class LoanController 
{
	@Autowired
    public LoanService lser;
	  
	//AdminModel
	@PostMapping("/postadmin")
	public AdminModel postD(AdminModel amodel)
	{
		return lser.post1(amodel);
	}
	@GetMapping("/getadmin")
	public List<AdminModel> getD()
	{
		return lser.get1();
	}
	@PutMapping("/putadmin")
	public AdminModel putD(AdminModel amodel1)
	{
		return lser.put1(amodel1);
	}
	@DeleteMapping("/deladmin/{cpas}")
	public String deleteD(@PathVariable("cpas") String password)
	{
		lser.delete1(password);
		return "Deleted";
	}
	
	//LoanApplicationModel
	
	@PostMapping("/postloan")
	public LoanApplicationModel postD1(LoanApplicationModel amodel3)
	{
		return lser.post2(amodel3);
	}
	@GetMapping("/getloan")
	public List<LoanApplicationModel> getD1()
	{
		return lser.get2();
	}
	@PutMapping("/putloan")
	public LoanApplicationModel putD1(LoanApplicationModel amodel4)
	{
		return lser.put2(amodel4);
	}
	@DeleteMapping("/delloan/{cid}")
	public String deleteD1(@PathVariable("cid") int loanid)
	{
		lser.delete2(loanid);
		return "Deleted";
	}
	
	//LoginModel
	@PostMapping("/postlog")
	public LoginModel postD2(@RequestBody LoginModel amodel5)
	{
		return lser.post3(amodel5);
	}
	@GetMapping("/getlog")
	public List<LoginModel> getD2()
	{
		return lser.get3();
	}
	@PutMapping("/putlog")
	public LoginModel putD2(LoginModel amodel6)
	{
		return lser.put3(amodel6);
	}
	@DeleteMapping("/dellog/{id}")
	public String deleteD2(@PathVariable ("id")String id)
	{
		lser.delete3(id);
		return "Deleted";
	}
	
	//UserModel
	@PostMapping("/postuser")
	public UserModel postD3(UserModel amodel7)
	{
		return lser.post4(amodel7);
	}
	@GetMapping("/getuser")
	public List<UserModel> getD3()
	{
		return lser.get4();
	}
	@PutMapping("/putuser")
	public UserModel putD3(UserModel amodel8)
	{
		return lser.put4(amodel8);
	}
	@DeleteMapping("/deluser/{aid}")
	public String deleteD3(@PathVariable("aid") int id)
	{
		lser.delete4(id);
		return "Deleted";
	}
	
}