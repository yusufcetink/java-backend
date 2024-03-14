package yusuf.panel.business.concretes;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yusuf.panel.business.abstracts.UserService;
import yusuf.panel.core.utilities.results.DataResult;
import yusuf.panel.core.utilities.results.ErrorResult;
import yusuf.panel.core.utilities.results.Result;
import yusuf.panel.core.utilities.results.SuccessDataResult;
import yusuf.panel.core.utilities.results.SuccessResult;
import yusuf.panel.dataAccess.abstracts.UserDao;
import yusuf.panel.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Kullanıcılar Listelendi");
	}

	@Override
	public Result add(User user) {
		
		Base64.Encoder encoder = Base64.getEncoder();
		
		String encodedPassword = encoder.encodeToString(user.getPassword().getBytes());
		
		user.setPassword(encodedPassword);
		
		User existingUser = this.userDao.findByUserName(user.getUserName());
		
		if (existingUser==null) {
			this.userDao.save(user);
			return new SuccessResult("Kullanıcı Kaydedildi.");
		}
		else {
			return new ErrorResult("Kullanıcı Kaydedilemedi.");
		}
		
	}

	@Override
	public Result login(String userName, String password) {
		
		List<User> userList = this.userDao.findAll();
		
		for (User user : userList) {
			if (user.getUserName().equals(userName)) {
				Base64.Decoder decoder = Base64.getDecoder();
				byte[] byteDecodedPassword = decoder.decode(user.getPassword());
				String decodedPassword = new String(byteDecodedPassword);
				System.out.println(decodedPassword);
				if (decodedPassword.equals(password)) {
					return new SuccessResult("Giriş Başarılı");
				}
				else {
					return new ErrorResult("Şifre Yanlış");
				}
			}
		}
		return new ErrorResult("Kullanıcı Bulunamadı");
	}

}
