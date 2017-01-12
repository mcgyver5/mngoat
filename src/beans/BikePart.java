package beans;

public class BikePart {
	public BikePart(int id,String make, String model, int size, int price) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.size = size;
		this.price = price;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	private int id;
	private String make;
	private String model;
	private int size;
	private int price;
	private int weight;
	private String manufacturer;
	private String countryOfOrigin;
	public BikePart() {
		// TODO Auto-generated constructor stub
	}

}
