
public class CProfessor extends CUnit{
	//	老師（Professor）：包括姓名、職等（level，數字，0為助理教授、1為副教授、2為教授）
	//	protected String name;			//單位名稱
	//	protected CUnit parent; 			//所屬單位
	protected int level;
	protected String strLv;
	public static final String lv0 = "助理教授";
	public static final String lv1 = "副教授";
	public static final String lv2 = "教授";


	public CProfessor(String n, CUnit p, int l) {
		this.name = n;
		this.parent = p;
		this.level = l;
		switch(this.level){
		case 0:
			this.strLv = CProfessor.lv0;
			break;
		case 1:
			this.strLv = CProfessor.lv1;
			break;
		case 2:
			this.strLv = CProfessor.lv2;
			break;
		default:
			this.strLv = "error.";
		}
	}

	public CUnit getParent() {
		return this.parent;
	}

	@Override public void output() {
		System.out.printf("%s %s\n", this.name, this.strLv);
	}

}
