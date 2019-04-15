package com.legato.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.legato.demo.pojo.User;
import com.legato.demo.repository.UserRepository;
import com.legato.service.UserService;

@Service
public class UserImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);

	}

	@Override
	public User getUserById(Integer id) {
		Optional<User> op = userRepository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			return null;
		}

	}

	@Override
	public List<User> getAlluser(User user) {
		return userRepository.findAll();

	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);

	}

	@Override
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
		
	}

}
