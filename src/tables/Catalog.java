package tables;

public class Catalog {
	int id;
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Catalog(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*public boolean equals(Object ob) {
		if(this == ob) return true;
		if(getClass() != ob.getClass()) return false;
		Catalog c = (Catalog)ob;
		return name.equals(c.name);
	}*/
	
	public boolean equals(Catalog obj) {
		System.out.println("equsls :" + name.equals(obj.name));
		return name.equals(obj.name);
	}
	
	
	public String toString(){
		return name;
	}
	
	public int hashCode(){
		int hash = 0;
		hash += (name != null) ? name.hashCode() : 0;
		return hash;
	}
}
