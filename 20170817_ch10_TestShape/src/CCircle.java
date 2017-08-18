//請設計一名為Circle（圓形）之類別，並繼承至Shape
class CCircle extends CShape{
	//請實作Shape中之抽象方法使此類別得以被創建實體
	//請添加Circle所需之屬性
	protected double radius;
	
	// 建構子
	public CCircle (double r){
		//於創建時存入半徑	
		this.radius = r;
		this.area = this.computeArea();
		this.perimeter = this.computePerimeter();
	}

	@Override
	double computeArea() {
		return Math.PI * Math.pow(this.radius, 2);
	}

	@Override
	double computePerimeter() {
		return 2 * Math.PI * this.radius;
	}
}