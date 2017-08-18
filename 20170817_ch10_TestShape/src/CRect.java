//請設計一名為Rectangle（矩形）之類別，並繼承至Shape
class CRect extends CShape{
	//請實作Shape中之抽象方法使此類別得以被創建實體
	//請添加Rectangle所需之屬性
	protected double width;
	protected double height;
	
	// 建構子
	public CRect(double w, double h){
		//於創建時存入長與寬
		this.width = w;
		this.height = h;
		this.area = this.computeArea();
		this.perimeter = this.computePerimeter();
	}

	@Override
	double computeArea() {
		return this.width * this.height;
	}

	@Override
	double computePerimeter() {
		return (this.width + this.height) * 2;
	}
}
