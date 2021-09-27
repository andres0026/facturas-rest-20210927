package com.empresa.microservicios.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.microservicios.models.Factura;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
	
	@PostMapping
	public String crearFactura(@RequestBody Factura factura) {
		
		//Recuperar los datos de la factura
		System.out.println(factura.getConcepto());
		
		//Insertar la factura en base de datos
		
		return "Todo OK";
	}
	
	@GetMapping("/{facturaID}")
	public Factura recuperarFactura(@PathVariable String facturaID) {
		
		System.out.println(facturaID);
		
		//Aquí tendría que recuperar de una base de datos la entidad asociada a facturaID
		
		//Vamos a crear un objeto de prueba
		Factura f = new Factura();
		f.setConcepto("Servicio de formación");
		f.setImporte(2348324);
		f.setCif("8383");
		
		return f;
		
		//Crea un objeto de tipo factura: 
		//return new Factura();
		
	}
	
	@DeleteMapping("/{facturaID}")
	public String borrarFactura(@PathVariable String facturaID) {
		
		System.out.println(facturaID);
		
		//Borrar factura en base de datos: 
		
		return "La operación se ha realizado con éxito";
		
	}

}
