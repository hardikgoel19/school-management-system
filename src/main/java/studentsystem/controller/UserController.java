package studentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import studentsystem.model.User;
import studentsystem.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/save")
	private User save(@RequestBody User user) {
		return userRepository.save(user);
	}

	@GetMapping("/getAll")
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@GetMapping("/getById/{id}")
	public User getAll(@PathVariable Long id) {
		return userRepository.findOne(id);
	}

}
