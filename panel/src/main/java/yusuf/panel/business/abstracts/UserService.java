package yusuf.panel.business.abstracts;

import java.util.List;

import yusuf.panel.core.utilities.results.DataResult;
import yusuf.panel.core.utilities.results.Result;
import yusuf.panel.entities.concretes.User;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	Result add(User user);
	
	Result login(String userName,String password);
}
