package restaurant.restaurantManagement.domain;

public class RestaurantCategory {

	Integer id;
	String name;
	
	public RestaurantCategory() {
		
	}
	public RestaurantCategory(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "RestaurantCategory [id=" + id + ", name=" + name + "]";
	}
	
	

	
	
	
}
