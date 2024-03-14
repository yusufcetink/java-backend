package yusuf.panel.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "user_role")
	private int userRole;
	
	@Column(name = "user_firstname")
	private String userFirstName;
	
	@Column(name = "user_surname")
	private String userSurname;
	
	@NotBlank
	@NotNull
	@Column(name = "user_name")
	private String userName;
	
	@NotBlank
	@NotNull
	@Column(name = "password")
	private String password;
	
	@Email
	@Column(name = "email")
	private String email;
}
