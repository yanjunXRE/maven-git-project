package devopsproject;

public class restaurant {

	protected String name;
	public restaurant(String name, String address, String image, String phone, String description) {
		super();
		this.name = name;
		this.address = address;
		this.image = image;
		this.phone = phone;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	protected String address;
	protected String image;
	protected String phone;
	protected String description;
}
