import java.lang.*;
import java.util.*;
public class TestUniversity {

	// static 
	public static Scanner sc = new Scanner(System.in);

	static CUniversity tUni = new CUniversity("NTUST");
	static CUnit posNow = tUni;

	static CDepartment tCD1 = new CDepartment("電子系", tUni);
	static CDepartment tCD2 = new CDepartment("機械系", tUni);

	static CAdministration tCA1 = new CAdministration("教務處", tUni);
	static CAdministration tCA2 = new CAdministration("學務處", tUni);

	static CFaculty tCF1 = new CFaculty("金剛", tCD1, "食物管理");
	static CFaculty tCF2 = new CFaculty("香蕉", tCD2, "預算管理");
	static CFaculty tCF3 = new CFaculty("豬蹄旁", tCA1, "課程安排");
	static CFaculty tCF4 = new CFaculty("肉圓", tCA2, "社團督導");
	static CFaculty tCF5 = new CFaculty("貢丸", tCA2, "副主委");

	static CProfessor tCP1 = new CProfessor("陳伯奇", tCD1, 1);
	static CProfessor tCP2 = new CProfessor("柳盛洋", tCD2, 0);
	static CProfessor tCP3 = new CProfessor("林志順", tCD2, 2);

	static CStudent tCS1 = new CStudent("陳維漢", tCD1, "B97", 2008);
	static CStudent tCS2 = new CStudent("薛順益", tCD2, "B96", 2007);
	static CStudent tCS3 = new CStudent("游秉勳", tCD2, "B95", 2006);

	public static void main(String[] args) {
		tUni.newCDepart(tCD1);
		tUni.newCDepart(tCD2);

		tUni.newCAdmin(tCA1);
		tUni.newCAdmin(tCA2);

		tCD1.newCFacu(tCF1);
		tCD2.newCFacu(tCF2);
		tCA1.newCFacu(tCF3);
		tCA2.newCFacu(tCF4);
		tCA2.newCFacu(tCF5);

		tCD1.newCPro(tCP1);
		tCD2.newCPro(tCP2);
		tCD2.newCPro(tCP3);

		tCD1.newCStu(tCS1);
		tCD2.newCStu(tCS2);
		tCD2.newCStu(tCS3);
		
		// test
		//		test();
		// main code
		mainCode();
	}

	public static void mainCode() {
		do {
			System.out.println("= = = = = = = =\n" + posNow.name + "\n" + "= = = = = = = =");
			System.out.println("1:新增, 2:進入, 3:印出所有人員, -1:結束: ");
			int option = sc.nextInt();
			switch(option) {
			case -1:
				return;
				// Quit
			case 1:
				newCDOrCA();
				break;
			case 2:
				intoCDOrCA();
				break;
			case 3:
				posNow.output();
				break;

			default:
				System.out.println("Input Error.");
			}
		} while(true);

	}
	public static void newCDOrCA() {
		do {
			System.out.println("1:學系, 2:行政單位, -1:取消:");
			int op = sc.nextInt();
			switch(op) {
			case -1:
				return;
			case 1:
				System.out.println("系名:\n");
				//				sc.nextLine();
				String str = sc.next();
				tUni.newCDepart(new CDepartment(str, tUni));
				System.out.println("新增成功 !!");
				return;
			case 2:
				System.out.println("單位名:\n");
				//				sc.nextLine();
				String str2 = sc.next();
				tUni.newCAdmin(new CAdministration(str2, tUni));
				System.out.println("新增成功 !!");
				return;
			default:
				System.out.println("Input Error.");
			}

		} while(true);
	}
	public static void intoCDOrCA() {
		do {
			for(int i = 0; i < tUni.arrCAdminCount; i++) {
				System.out.println(i + " " + tUni.arrCAdmin[i].name);
			}
			for(int i = 0; i < tUni.arrCDepartCount; i++) {
				System.out.println((tUni.arrCAdminCount + i) + " " + tUni.arrCDepart[i].name);
			}

			System.out.println("選項 (輸入-1返回): ");
			int op = sc.nextInt();
			if(op == -1) {
				return;
			}
			if(op < tUni.arrCAdminCount) {
				posNow = tUni.arrCAdmin[op];
				// 進入 某單位
				intoCA();
				return;
			}
			if( op > (tUni.arrCAdminCount - 1) && op < tUni.arrCDepartCount + tUni.arrCAdminCount) {
				posNow = tUni.arrCDepart[op - tUni.arrCAdminCount];
				// 進入 某學系
				intoCD();
				return;
			}
		} while(true);
	}
	public static void intoCA() {
		do {
			System.out.println("= = = = = = = =\n" + posNow.parent.name + " > " + posNow.name + "\n" + "= = = = = = = =");
			System.out.println("1:新增行政人員, 2:印出所有成員, -1:返回:");
			int op = sc.nextInt();
			switch(op) {
			case -1:
				posNow = posNow.parent;
				return;
			case 1:
				System.out.println("請輸入 姓名：");
				String nameCF = sc.next();
				System.out.println("請輸入 職稱：");
				String posCF = sc.next();
				for(int i = 0; i < tUni.arrCAdminCount; i++) {
					if(tUni.arrCAdmin[i] == posNow) {
						tUni.arrCAdmin[i].newCFacu(new CFaculty(nameCF, posNow, posCF));
					}
				}
				System.out.println("新增成功!!");
				break;
			case 2:
				posNow.output();
				break;
			default:
				System.out.println("Input Error.");
			}
		}while(true);

	}
	public static void intoCD() {
		do {
			System.out.println("= = = = = = = =\n" + posNow.parent.name + " > " + posNow.name + "\n" + "= = = = = = = =");
			System.out.println("1:新增行政人員, 2:新增教師, 3:新增學生, 4:印出所有成員, -1:返回:");
			int op = sc.nextInt();
			switch(op) {
			case -1:
				posNow = posNow.parent;
				return;
			case 1:
				System.out.println("請輸入 姓名：");
				String nameCF = sc.next();
				System.out.println("請輸入 職稱：");
				String posCF = sc.next();
				for(int i = 0; i < tUni.arrCDepartCount; i++) {
					if(tUni.arrCDepart[i] == posNow) {
						tUni.arrCDepart[i].newCFacu(new CFaculty(nameCF, posNow, posCF));
					}
				}
				System.out.println("新增成功!!");
				break;
			case 2:
				System.out.println("請輸入 姓名：");
				String nameCP = sc.next();
				System.out.println("請輸入 教授職等：");
				int lvCF = sc.nextInt();
				if(lvCF > 2 || lvCF < 0) 
					break;
				for(int i = 0; i < tUni.arrCDepartCount; i++) {
					if(tUni.arrCDepart[i] == posNow) {
						tUni.arrCDepart[i].newCPro(new CProfessor(nameCP, posNow, lvCF));;
					}
				}			
				System.out.println("新增成功!!");
				break;
			case 3:
				System.out.println("請輸入 姓名：");
				String nameCS = sc.next();
				System.out.println("請輸入 學號：");
				String noCS = sc.next();
				System.out.println("請輸入 入學年份：");
				int yearCS = sc.nextInt();
				for(int i = 0; i < tUni.arrCDepartCount; i++) {
					if(tUni.arrCDepart[i] == posNow) {
						tUni.arrCDepart[i].newCStu(new CStudent(nameCS, posNow, noCS, yearCS));
					}
				}
				System.out.println("新增成功!!");
				break;
			case 4:
				posNow.output();
				break;
			default:
				System.out.println("Input Error.");
			}
		}while(true);
	}

	public static void test() {

		line();
		System.out.println("// 大學");
		tUni.output();
		System.out.println("getCount: " + tUni.getCACount() + "  " + tUni.getCDCount());

		line();
		System.out.println("// 學系");
		tCD1.output();
		System.out.println(tCD1.name + " getCount: " + tCD1.getCFCount() + "  " + tCD1.getCSCount() + "  " + tCD1.getCPCount());
		tCD2.output();
		System.out.println(tCD2.name + " getCount: " + tCD2.getCFCount() + "  " + tCD2.getCSCount() + "  " + tCD2.getCPCount());

		line();
		System.out.println("// 教學單位");
		tCA1.output();
		System.out.println(tCA1.name + " getCount: " + tCA1.getCFCount() );
		tCA2.output();
		System.out.println(tCA2.name + " getCount: " + tCA2.getCFCount() );

		line();
		System.out.println("// 行政人員");
		tCF1.output();
		tCF2.output();
		tCF3.output();
		tCF4.output();
		tCF5.output();
		System.out.println();

		line();
		System.out.println("// 教授");
		tCP1.output();
		tCP2.output();
		tCP3.output();
		System.out.println();

		line();
		System.out.println("// 學生");
		tCS1.output();
		tCS2.output();
		tCS3.output();
		System.out.println();
	}
	public static void line() {
		System.out.println("----------------------------------------------------------------------");
	}

}
