package regres.objects;

public class User {
	public Data data;
	public class Data{
		public int id;
		public String email;
		public String first_name;
		public String last_name;
		public String avatar;
	}
	public Support support;
	public class Support{
		public String url;
		public String text;
	}
}
