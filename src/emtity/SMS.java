package emtity;

public class SMS {
		/*
		 * ����Ϣ�Ļ�����
		 */
	private int mno; //���
	private String mname; //����
	private String mtime; //����ʱ��
	
	public SMS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SMS(int mno, String mname, String mtime) {
		super();
		this.mno = mno;
		this.mname = mname;
		this.mtime = mtime;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	
	
}
