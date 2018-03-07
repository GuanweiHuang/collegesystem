package emtity;
/*
 * 班级的基础类
 */
public class TbClass {
		private int cno;		//编号
		private String cname;	//班级名
		private int cnumber;	//学生
		private int ctea;		//教师外键
		public TbClass() {
			super();
			// TODO Auto-generated constructor stub
		}
		public TbClass(int cno, String cname, int cnumber, int ctea) {
			super();
			this.cno = cno;
			this.cname = cname;
			this.cnumber = cnumber;
			this.ctea = ctea;
		}
		public int getCno() {
			return cno;
		}
		public void setCno(int cno) {
			this.cno = cno;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public int getCnumber() {
			return cnumber;
		}
		public void setCnumber(int cnumber) {
			this.cnumber = cnumber;
		}
		public int getCtea() {
			return ctea;
		}
		public void setCtea(int ctea) {
			this.ctea = ctea;
		}
		
		
}
