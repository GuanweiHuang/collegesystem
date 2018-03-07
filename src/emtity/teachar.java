package emtity;
/*
 * 教师的基础类
 */
public class teachar {
		private int tno;		//编号
		private String tname;	//姓名
		private int tage;		//年龄
		private String tsex;	//性别
		private String tpost;	//职务
		private String taddress; //地址
		private String tphone;	 //电话号码
		private String tauthor;	//用户名
		private String tpwd;    //密码
		
		public teachar() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		public teachar(int tno, String tname, int tage, String tsex,
				String tpost, String taddress, String tphone, String tauthor,
				String tpwd) {
			super();
			this.tno = tno;
			this.tname = tname;
			this.tage = tage;
			this.tsex = tsex;
			this.tpost = tpost;
			this.taddress = taddress;
			this.tphone = tphone;
			this.tauthor = tauthor;
			this.tpwd = tpwd;
		}

		public int getTno() {
			return tno;
		}

		public void setTno(int tno) {
			this.tno = tno;
		}

		public String getTname() {
			return tname;
		}

		public void setTname(String tname) {
			this.tname = tname;
		}

		public int getTage() {
			return tage;
		}

		public void setTage(int tage) {
			this.tage = tage;
		}

		public String getTsex() {
			return tsex;
		}

		public void setTsex(String tsex) {
			this.tsex = tsex;
		}

		public String getTauthor() {
			return tauthor;
		}

		public void setTauthor(String tauthor) {
			this.tauthor = tauthor;
		}

		public String getTpwd() {
			return tpwd;
		}

		public void setTpwd(String tpwd) {
			this.tpwd = tpwd;
		}



		public String getTpost() {
			return tpost;
		}



		public void setTpost(String tpost) {
			this.tpost = tpost;
		}



		public String getTaddress() {
			return taddress;
		}



		public void setTaddress(String taddress) {
			this.taddress = taddress;
		}



		public String getTphone() {
			return tphone;
		}



		public void setTphone(String tphone) {
			this.tphone = tphone;
		}
		
		
}
