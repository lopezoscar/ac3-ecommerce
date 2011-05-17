package model.users;

public class Permiso {
	
	public String nombre;
	
	public boolean tengoPermiso;
	
	public Permiso(String nombre){
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isTengoPermiso() {
		return tengoPermiso;
	}

	public void setTengoPermiso(boolean tengoPermiso) {
		this.tengoPermiso = tengoPermiso;
	}
	
	 

}
