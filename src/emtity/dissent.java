package emtity;

public class dissent {
		//信息的封装类
	private int dsno;		//编号
	private String dsname;	//内容
	private String dlei;	//类型
	private String dstime;	//发布时间
	private int entno;		//收件老师
	private String stuno;	//发件人
	public dissent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public dissent(int dsno, String dsname, String dlei, String dstime,
			int entno, String stuno) {
		super();
		this.dsno = dsno;
		this.dsname = dsname;
		this.dlei = dlei;
		this.dstime = dstime;
		this.entno = entno;
		this.stuno = stuno;
	}
	public int getDsno() {
		return dsno;
	}
	public void setDsno(int dsno) {
		this.dsno = dsno;
	}
	public String getDsname() {
		return dsname;
	}
	public void setDsname(String dsname) {
		this.dsname = dsname;
	}
	public String getDlei() {
		return dlei;
	}
	public void setDlei(String dlei) {
		this.dlei = dlei;
	}
	public String getDstime() {
		return dstime;
	}
	public void setDstime(String dstime) {
		this.dstime = dstime;
	}
	public int getEntno() {
		return entno;
	}
	public void setEntno(int entno) {
		this.entno = entno;
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	
	
}
