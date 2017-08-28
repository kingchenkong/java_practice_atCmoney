
public class CDepartment extends CUnit{
	//	學系（Department）：包括名稱、多名人員（行政人員、老師或學生）
	//	protected String name;			//單位名稱
	//	protected CUnit parent; 			//所屬單位
	
	protected CProfessor[] arrCPro;
	protected CStudent[] arrCStu;
	protected CFaculty[] arrCFacu;
	
	protected int arrCFCount;
	protected int arrCProCount;
	protected int arrCStuCount;
	
	
	public CDepartment(String n, CUnit p) {
		this.name = n;
		this.parent = p;
		
		this.arrCPro = new CProfessor[100];
		this.arrCStu = new CStudent[100];
		this.arrCFacu = new CFaculty[100];
		
		this.arrCFCount = 0;
		this.arrCProCount = 0;
		this.arrCStuCount = 0;
	}
	// new
	public void newCPro(CProfessor cp) {
		this.arrCPro[this.arrCProCount++] = cp;
	}
	public void newCStu(CStudent cs) {
		this.arrCStu[this.arrCStuCount++] = cs;
	}
	public void newCFacu(CFaculty cf) {
		this.arrCFacu[this.arrCFCount++] = cf;
	}
	
	// getter
	public int getCPCount() {
		return this.arrCProCount;
	}
	public int getCSCount() {
		return this.arrCStuCount;
	}
	public int getCFCount() {
		return this.arrCFCount;
	}
	
	@Override
	public void output() {
		for(int i = 0; i < this.arrCFCount; i++) {
//			System.out.println(i + " " + this.arrCFacu[i].name);
			System.out.print(this.arrCFacu[i].parent.name + " ");
			this.arrCFacu[i].output();
		}
		for(int i = 0; i < this.arrCProCount; i++) {
//			System.out.println( (this.arrCFCount + i) + " " + this.arrCPro[i].name);
			System.out.print(this.arrCPro[i].parent.name+ " ");
			this.arrCPro[i].output();
		}
		for(int i = 0; i < this.arrCStuCount; i++) {
//			System.out.println( (this.arrCFCount + this.arrCProCount + i ) + " " + this.arrCStu[i].name);
			System.out.print(this.arrCStu[i].parent.name + " ");
			this.arrCStu[i].output();
		}
		
		System.out.println();
	}

}
