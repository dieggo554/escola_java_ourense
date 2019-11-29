package com.vn.ejemplospring.demospring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vn.ejemplospring.demospring.modelo.CuentaBanc;
import com.vn.ejemplospring.demospring.modelo.CuentasDAOpanama;

@RestController
@CrossOrigin(origins = "*")
public class ServicioBancarioREST {
	
	// Nosotros NO instanciamos, lo hace Spring
	// Nosotros NO gestionamos la dependencia, lo hace Spring
	// Tampoco asignamos el valor, lo hace Spring
	// Esto es la INYECCIÓN DE DEPENDENCIAS
	@Autowired
	private CuentasDAOpanama repo;
	
	@RequestMapping(path = "/cuentas", method = { RequestMethod.POST /*, RequestMethod.PUT, ... */})	// Nos permite capturar varios métodos HTTP
//	@PostMapping									// Solo el método post
	public CuentaBanc crearCuentaAIngenuo(@RequestBody CuentaBanc cuenta) {
		
		CuentaBanc cuentaNueva = repo.save(cuenta);
		System.out.println(">>> CuentaBanc recibida! " + cuenta.toString());
		return cuentaNueva;
	}
	
	@RequestMapping(path = "/cuentas", method = RequestMethod.GET)
	public List<CuentaBanc> obtenerTodas() {
		
		System.out.println(">>> Nº cuentas " + repo.count());
		return repo.findAll();
	}
	
	@DeleteMapping("/cuentas/{id}")
	public void eliminarCuenta(@PathVariable Integer id) {
		
		System.out.println(">>> Eliminando la cuenta: " + repo.findById(id).get());
		repo.deleteById(id);
	}
	// TODO: Hacer el PUT para modificar
	@PutMapping("/cuentas/{id}")
	public CuentaBanc modificarCuenta(@PathVariable Integer id, @RequestBody CuentaBanc cuentaModif) {
		// Si el id no existe, crea una nueva cuenta con el id secuencial
		if (cuentaModif.getId() == id) {
			System.out.println(">>> MODIFICAR " + id);
			return repo.save(cuentaModif);
		} else {
			System.out.println(">>> PUT/MODIFICAR ERROR " + id);
			return null;
		}
	}
	
	// Version propia
//	@PutMapping("/cuentas/{id}")
//	public CuentaBanc modificarCuenta(@PathVariable Integer id, @RequestBody CuentaBanc cuenta) {
//		
//		Optional<CuentaBanc> cuentaDB = repo.findById(id);
//		System.out.println(">>> Modificando : " + cuentaDB.get() + " con " + cuenta);
//		if (cuentaDB.isPresent()) {
//			System.out.println(">>> Existe");
//			BeanUtils.copyProperties(cuenta, cuentaDB);
//			return repo.save(cuentaDB.get());
//		}
//		return null;
//	}
}
