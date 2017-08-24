// 編號	姓名		身分證		生日			電話
public class MemberData {
	private int No;
	private String name;
	private IDCode ID; 
	private Date date; 
	private String phone;
	private String data;

	public MemberData(String no, String name, String id, String date, String ph) {

		if(MemberData.noIsValid(no))
			this.No = Integer.parseInt(no);
		this.name = name;
		this.ID = new IDCode(id);
		this.date = new Date(date);
		if(MemberData.phoneIsValid(ph))
			this.phone = ph;
		this.data = String.format("%03d \t%3s \t%s \t%s \t%s", this.No, this.name, this.ID.getIDStr(), this.date.getDate(), this.phone);
	}	
	// getter
	public String getData() {
		return this.data;
	}
	// output
	public void output() {
		System.out.println(this.data);
	}
	public static boolean noIsValid(String no) {
		char[] arrNo = no.toCharArray();
		for(int i = 0; i < arrNo.length; i++) 
			if( (int)arrNo[i] < 48 || (int)arrNo[i] > 57)
				return false;
		return true;
	}
	public static boolean phoneIsValid(String ph) {
		char[] arrPh = ph.toCharArray();
		for(int i = 0; i < arrPh.length; i++) 
			if( (int)arrPh[i] < 48 || (int)arrPh[i] > 57)
				return false;
		return true;
	}


}
