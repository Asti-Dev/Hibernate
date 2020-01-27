package isil.trabajo.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="edificios")

public class Edificio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	 
	@Column(name="nombre")
	protected String nombre;
	 
	@Column(name="cantidad_pisos")
	protected int cantidadPisos;
	 
	@Column(name="altura")
	protected double altura;
	
	@Column(name="direccion")
	protected String direccion;
	
	public Edificio(String nombre, int cantidadPisos, double altura, String direccion) {
		  super();
		  this.nombre = nombre;
		  this.cantidadPisos = cantidadPisos;
		  this.altura = altura;
		  this.direccion = direccion;
		 }

	public Edificio(int id, String nombre, int cantidadPisos, double altura, String direccion) {
		  super();
		  this.id = id;
		  this.nombre = nombre;
		  this.cantidadPisos = cantidadPisos;
		  this.altura = altura;
		  this.direccion =direccion;
		 }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadPisos() {
		return cantidadPisos;
	}

	public void setCantidadPisos(int cantidadPisos) {
		this.cantidadPisos = cantidadPisos;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
