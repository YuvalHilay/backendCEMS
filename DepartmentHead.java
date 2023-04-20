package mod;

import java.io.Serializable;

public class DepartmentHead extends User implements Serializable {
		/**
	 * 
	 */
	    private static final long serialVersionUID = 1L;
		private DepartmentHeadType type;
		

		public DepartmentHead(String firstName, String lastName, Integer id, String email, String phoneNumber, String username,
				String password, boolean isLoggedIn, DepartmentHeadType type) {
			super(firstName, lastName, id, email, phoneNumber, username, password, isLoggedIn, isLoggedIn, isLoggedIn, isLoggedIn);
			this.type = type;
		}
		
		public DepartmentHead(User user, DepartmentHeadType type) {
			super(user.getFirstName(), user.getLastName(), user.getId(), user.getEmail(), user.getPhoneNumber(), user.getUsername(), 
					user.getPassword(), user.isLoggedIn(), user.isDepartmentHead(), user.isStudent(), user.isDepartmentHead());
			this.type = type;
		}

		public DepartmentHeadType getType() {
			return type;
		}

		public void setType(DepartmentHeadType type) {
			this.type = type;
		}
}
