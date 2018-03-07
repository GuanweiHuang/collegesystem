package emtity;

public class stucourse {
		private int kno;
		private String courname;
		private int cteaer;
		public stucourse() {
			super();
			// TODO Auto-generated constructor stub
		}
		public stucourse(int kno, String courname, int cteaer) {
			super();
			this.kno = kno;
			this.courname = courname;
			this.cteaer = cteaer;
		}
		public int getKno() {
			return kno;
		}
		public void setKno(int kno) {
			this.kno = kno;
		}
		public String getCourname() {
			return courname;
		}
		public void setCourname(String courname) {
			this.courname = courname;
		}
		public int getCteaer() {
			return cteaer;
		}
		public void setCteaer(int cteaer) {
			this.cteaer = cteaer;
		}
		
		
}
