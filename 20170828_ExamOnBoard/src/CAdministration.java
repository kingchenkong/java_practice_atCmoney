
public class CAdministration extends CUnit{
	//	行政單位（Administration）：包括名稱、多名行政人員
	//	protected String name;			//單位名稱
	//	protected CUnit parent; 			//所屬單位
	protected CFaculty[] arrCFacu;
	protected int arrCFCount;
	

	public CAdministration(String n, CUnit p) {
		this.name = n;
		this.parent = p;
		this.arrCFacu = new CFaculty[100];
		this.arrCFCount = 0;
	}
	// new
	public void newCFacu(CFaculty cf) {
		this.arrCFacu[this.arrCFCount++] = cf;
		
	}
	// getter
	public int getCFCount() {
		return this.arrCFCount;
	}
	
	@Override
	public void output() {
		for(int i = 0; i < this.arrCFCount; i++) {
//			System.out.println(this.arrCFacu[i].parent.name + " " + this.arrCFacu[i].name+ " "  + this.arrCFacu[i].position);
			System.out.print(this.arrCFacu[i].parent.name + " ");
			this.arrCFacu[i].output();
		}
		System.out.println();
	}

}
