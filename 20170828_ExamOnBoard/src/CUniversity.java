
public class CUniversity extends CUnit{
	// 大學（University）：包括名稱，多個單位（行政單位或學系）
	//	protected String name;			//單位名稱
	//	protected CUnit parent; 			//所屬單位

	protected CUnit[] arrCU;
	protected CAdministration[] arrCAdmin;
	protected CDepartment[] arrCDepart;
	protected int arrCAdminCount;
	protected int arrCDepartCount;

	public CUniversity(String n) {
		this.name = n;
		this.arrCAdmin = new CAdministration[100];
		this.arrCDepart = new CDepartment[100];
		this.arrCAdminCount = 0;
		this.arrCDepartCount = 0;
	}
	// new
	public void newCAdmin(CAdministration ca) {
		this.arrCAdmin[this.arrCAdminCount++] = ca;
	}
	public void newCDepart(CDepartment cd) {
		this.arrCDepart[this.arrCDepartCount++] = cd;
	}
	
	// getter
	public int getCACount() {
		return this.arrCAdminCount;
	}
	public int getCDCount() {
		return this.arrCDepartCount;
	}
	
	@Override public void output() {
//		for(int i = 0; i < this.arrCAdminCount; i++) {
//			System.out.println(i + " " + this.arrCAdmin[i].name);
//			this.arrCAdmin[i].output();
//		}
//		for(int i = 0; i <this.arrCDepartCount; i++) {
//			System.out.println((arrCAdminCount + i) + " " + this.arrCDepart[i].name);
//			this.arrCDepart[i].output();
//		}
		for(int i = 0; i < this.arrCAdminCount; i++) {
			this.arrCAdmin[i].output();
		}
		for(int i = 0; i <this.arrCDepartCount; i++) {
			this.arrCDepart[i].output();
		}
		
	}

}
