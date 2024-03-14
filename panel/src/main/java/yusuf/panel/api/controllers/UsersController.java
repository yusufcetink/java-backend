package yusuf.panel.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import yusuf.panel.business.abstracts.UserService;
import yusuf.panel.core.utilities.results.DataResult;
import yusuf.panel.core.utilities.results.Result;
import yusuf.panel.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {
	
	private UserService userService;

	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<User>> getAll() {
		return this.userService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody User user) {
		return this.userService.add(user);
	}
	
	@PostMapping("/login")
	public Result login(String userName, String password) {
		return this.userService.login(userName, password);
	}
}
