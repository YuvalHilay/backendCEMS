package mod;

import java.io.Serializable;

public class Student extends User implements Serializable {
		/**
	 * 
	 */
	    private static final long serialVersionUID = 1L;
		private StudentType type;
		

		public Student(String firstName, String lastName, Integer id, String email, String phoneNumber, String username,
				String password, boolean isLoggedIn, StudentType type) {
			super(firstName, lastName, id, email, phoneNumber, username, password, isLoggedIn, isLoggedIn, isLoggedIn, isLoggedIn);
			
			this.type = type;
		}
		
		public Student(User user, StudentType type) {
			super(user.getFirstName(), user.getLastName(), user.getId(), user.getEmail(), user.getPhoneNumber(), user.getUsername(), 
					user.getPassword(), user.isLoggedIn(), user.isDepartmentHead(), user.isStudent(), user.islecturer());
			this.type = type;
		}

		public StudentType getType() {
			return type;
		}

		public void setType(StudentType type) {
			this.type = type;
		}
}
