
public class CStudent extends CUnit{
	//學生（Student）：包括姓名、學號（字串）、入學年份（數字，西元）
	//	protected String name;			//單位名稱
	//	protected CUnit parent; 			//所屬單位
	protected String stuNo;
	protected int year;

	public CStudent(String n, CUnit p, String sn, int y) {
		this.name = n;
		this.parent = p;
		this.stuNo = sn;
		this.year = y;
	}
	
	public CUnit getParent() {
		return this.parent;
	}
	
	@Override public void output() {
		System.out.printf("%s %s %d\n", this.name, this.stuNo, this.year);
	}

}
