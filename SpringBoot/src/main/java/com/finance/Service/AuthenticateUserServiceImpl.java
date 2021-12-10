package com.finance.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finance.Model.User;
import com.finance.Repository.UserRepository;

@Service
@Transactional
public class AuthenticateUserServiceImpl implements AuthenticateUserService {
	@Autowired
	UserRepository adRepo;

	@Override
	public List<User> getUserdetails(){
		
		return adRepo.findAll();
	}

//	@Override
//	public boolean updateUser(int regid) {
//		
//		Userdetails newusr=adRepo.findById(regid).get();
////		newusr=user;
//	String verify="true";
//	newusr.setIsverified(verify);
//		adRepo.save(newusr);
//		// TODO Auto-generated method stub
//		return true;
//	}

	@Override
	public User findUser(long regid) {
		// TODO Auto-generated method stub
		return adRepo.findById(regid).get();
	}

//	@Override
//	public boolean deleteUser(Userdetails user) {
//		adRepo.delete(user);
//		// TODO Auto-generated method stub
//		return true;
//	}
//	

//	@Override
//	public boolean deleteProduct(Userdetails user) {
//        adRepo.delete(user);
//		
//		return true;
//	}
	@Override
	public boolean deleteUser(long regid) {
		User newusr=adRepo.findById(regid).get();
		//newusr=user;
	//String verify="true";
	//newusr.setIsverified(verify);
		//adRepo.save(newusr);
	adRepo.delete(newusr);
		// TODO Auto-generated method stub
		return true;
		
		

}
	@Override
	public boolean updateUser(long regid) {
		
		User newusr=adRepo.findById(regid).get();
//		newusr=user;
	String verify="true";
	newusr.setIsVerified(verify);
		adRepo.save(newusr);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addUser(User user) {
		adRepo.save(user);
		return true;
	}

	

}
