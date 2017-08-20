public class File extends FileEntity {
	// Attributes
	
	// Constructor
	public File(String n) {
		super(n);
	}
	public File(String n, Directory p) {
		super(n, p);
		FileEntity[] arr = p.getDirList();
		arr[p.getItemCount()] = this;
		p.setAttributes(arr, p.getItemCount() + 1);
	}
	// Method
	
}

