
public class Accounting {

	// Attributes
	private Record[] records;
	private int count;
	
	// Method
	public Accounting() {
		this.records = new Record[50];
		this.count = 0;
	}
	
	public void add(String name, int price, CTime recordTime) {
		Record record = new Record(name, price, recordTime);
		if(this.count == this.records.length) {
			this.resize();
		}
		this.records[this.count++] = record;
	}
	public void print() {
		Record record;
		for(int i = 0; i < count; i++) {
			record = this.records[i];
			System.out.printf("%12s \t %4d \t", record.getName(), record.getPrice());
			record.getRecordTime().print();
			System.out.println("");
			
		}
		
	}
	public void resize() {
		Record[] recordsForCopy = new Record[this.records.length*2];
		for(int i = 0; i < this.count; i++) {
			recordsForCopy[i] = this.records[i];
		}
		this.records = null;
		this.records = recordsForCopy;
		
	}
	
	// last {
}
