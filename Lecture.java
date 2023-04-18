package mod;

import java.io.Serializable;

public class Lecture extends User implements Serializable {
		/**
	 * 
	 */
	    private static final long serialVersionUID = 1L;
		private LectureType type;
		

		public Lecture(String firstName, String lastName, Integer id, String email, String phoneNumber, String username,
				String password, boolean isLoggedIn, LectureType type) {
			super(firstName, lastName, id, email, phoneNumber, username, password, isLoggedIn, isLoggedIn, isLoggedIn, isLoggedIn);
			
			this.type = type;
		}
		
		public Lecture(User user, LectureType type) {
			super(user.getFirstName(), user.getLastName(), user.getId(), user.getEmail(), user.getPhoneNumber(), user.getUsername(), 
					user.getPassword(), user.isLoggedIn(), user.islecturer(), user.isDepartmentHead(), user.islecturer());
			this.type = type;
		}

		public LectureType getType() {
			return type;
		}

		public void setType(LectureType type) {
			this.type = type;
		}
}
