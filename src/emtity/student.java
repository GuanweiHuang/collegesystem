package emtity;
/*
 * ѧ���Ļ�����
 */
public class student {
		private int sno;  			//���
		private String sname;       //ѧ��
		private String sauthor;     //����
		private int sage; 			//����
		private String ssex;		//�Ա�
		private String spwd;		//����
		private String saddresss;	//��ַ
		private String sphone;		//�ֻ�����
		private String sbirth;		//��������
		private String sNation;		//����
		private String spolitic;	//������ò
		private int sclass;			//�༶���
		private int sstucourse;		//רҵ���
		private int teacher;		//��ʦ���
		
		public student() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		public student(int sno, String sname, String sauthor, int sage,
				String ssex, String spwd, String saddresss, String sphone,
				String sbirth, String sNation, String spolitic, int sclass,
				int sstucourse, int teacher) {
			super();
			this.sno = sno;
			this.sname = sname;
			this.sauthor = sauthor;
			this.sage = sage;
			this.ssex = ssex;
			this.spwd = spwd;
			this.saddresss = saddresss;
			this.sphone = sphone;
			this.sbirth = sbirth;
			this.sNation = sNation;
			this.spolitic = spolitic;
			this.sclass = sclass;
			this.sstucourse = sstucourse;
			this.teacher = teacher;
		}



		public int getSno() {
			return sno;
		}

		public void setSno(int sno) {
			this.sno = sno;
		}

		public String getSname() {
			return sname;
		}

		public void setSname(String sname) {
			this.sname = sname;
		}

		public String getSauthor() {
			return sauthor;
		}

		public void setSauthor(String sauthor) {
			this.sauthor = sauthor;
		}

		public int getSage() {
			return sage;
		}

		public void setSage(int sage) {
			this.sage = sage;
		}

		public String getSsex() {
			return ssex;
		}

		public void setSsex(String ssex) {
			this.ssex = ssex;
		}

		public String getSpwd() {
			return spwd;
		}

		public void setSpwd(String spwd) {
			this.spwd = spwd;
		}

		public String getSaddresss() {
			return saddresss;
		}

		public void setSaddresss(String saddresss) {
			this.saddresss = saddresss;
		}

		public String getSphone() {
			return sphone;
		}

		public void setSphone(String sphone) {
			this.sphone = sphone;
		}

		public int getSclass() {
			return sclass;
		}

		public void setSclass(int sclass) {
			this.sclass = sclass;
		}

		public int getSstucourse() {
			return sstucourse;
		}

		public void setSstucourse(int sstucourse) {
			this.sstucourse = sstucourse;
		}

		public int getTeacher() {
			return teacher;
		}

		public void setTeacher(int teacher) {
			this.teacher = teacher;
		}



		public String getSbirth() {
			return sbirth;
		}



		public void setSbirth(String sbirth) {
			this.sbirth = sbirth;
		}



		public String getsNation() {
			return sNation;
		}



		public void setsNation(String sNation) {
			this.sNation = sNation;
		}



		public String getSpolitic() {
			return spolitic;
		}



		public void setSpolitic(String spolitic) {
			this.spolitic = spolitic;
		}
		
		
		
}
