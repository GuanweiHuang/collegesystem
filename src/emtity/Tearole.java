package emtity;

public class Tearole {
    //�����ʦְ�Ƶ�����
	
	private String troname;		//��ʦ����
	private String trole;		//��ʦְ��
	private String troimages;	//֤��
	
	
	
	public Tearole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tearole(String troname, String trole, String troimages) {
		super();
		this.troname = troname;
		this.trole = trole;
		this.troimages = troimages;
	}
	public String getTroname() {
		return troname;
	}
	public void setTroname(String troname) {
		this.troname = troname;
	}
	public String getTrole() {
		return trole;
	}
	public void setTrole(String trole) {
		this.trole = trole;
	}
	public String getTroimages() {
		return troimages;
	}
	public void setTroimages(String troimages) {
		this.troimages = troimages;
	}
	
	
	
}
