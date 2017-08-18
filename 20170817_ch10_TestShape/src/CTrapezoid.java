//請設計一名為Trapezoid之類別，用以實作等腰梯形，並繼承至Shape
class CTrapezoid extends CShape{
	//請實作Shape中之抽象方法使此類別得以被創建實體
	//請添加Trapezoid所需之屬性
	protected double upper;
	protected double lower;
	protected double height;
	
	// 建構子
	public CTrapezoid (double u, double l, double h){
		//於創建時存入上底、下底與高
		this.upper = u;
		this.lower = l;
		this.height = h;
		this.area = this.computeArea();
		this.perimeter = this.computePerimeter();
	}

	@Override
	double computeArea() {
		return (this.upper + this.lower) * this.height / 2;
	}

	@Override
	double computePerimeter() {
		double edge = (this.upper - this.lower) / 2;
		double hypo = Math.sqrt( (Math.pow(edge, 2) + Math.pow(this.height, 2) ) );
		return this.upper + this.lower + 2 * hypo;
	}

	
	
}