package emtity;

public class dissent {
		//��Ϣ�ķ�װ��
	private int dsno;		//���
	private String dsname;	//����
	private String dlei;	//����
	private String dstime;	//����ʱ��
	private int entno;		//�ռ���ʦ
	private String stuno;	//������
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
