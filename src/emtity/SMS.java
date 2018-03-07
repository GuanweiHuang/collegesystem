package emtity;

public class SMS {
		/*
		 * 短消息的基础类
		 */
	private int mno; //编号
	private String mname; //内容
	private String mtime; //发布时间
	
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
