package yusuf.panel.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import yusuf.panel.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findByUserName(String userName);
}
