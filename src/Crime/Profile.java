package Crime;

public class Profile {
		protected String name;
		protected int id;
		protected String contact;
		protected Address a;
		protected int age;
		protected String email;
		static int count;
		private String gender;
		private String category;
		private String password;
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
<<<<<<< HEAD
		protected String gender;
		protected String category;
		protected String password;
=======
		
>>>>>>> eb8bdae5e9823cf95512a56d2f336fc2879be929
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public Address getA() {
			return a;
		}
		public int getAid(){
			return a.getAddressId();
		}
		public void setA(Address a) {
			this.a = a;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
}
