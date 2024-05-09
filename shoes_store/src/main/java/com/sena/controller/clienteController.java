package com.sena.controller;
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.interfacesService.IclienteService;
import com.sena.model.cliente;


	@RequestMapping("/api/v1/cliente")
	@RestController
	@CrossOrigin
	public class clienteController {
		@Autowired
		private IclienteService clienteService;
		
		@PostMapping("/")
		public ResponseEntity<Object> save(@ModelAttribute("cliente") cliente cliente){
				// condicion para cuando ya exista el  registro 
				List<cliente>listaClientesValidacion=clienteService.filtroNombreCliente(cliente.getPrimer_nombre());
				if(listaClientesValidacion.size()!=0){
					//ya tiene un registro activo
					return new ResponseEntity<>("El cliente ya se encuentra registrado",HttpStatus.BAD_REQUEST);		
				}	
				if (cliente.getTipo_documento().equals("")) {
					return new ResponseEntity<>("El tipo documento es obligatorio", HttpStatus.BAD_REQUEST);
				}
				if (cliente.getNumero_documento().equals("")) {
					return new ResponseEntity<>("El número de documento es obligatorio", HttpStatus.BAD_REQUEST);
				}
				if (cliente.getPrimer_nombre().equals("")) {
					return new ResponseEntity<>("El primer nombre es obligatorio", HttpStatus.BAD_REQUEST);
				}
				if (cliente.getPrimer_apellido().equals("")) {
					return new ResponseEntity<>("El primer apellido es obligatorio", HttpStatus.BAD_REQUEST);
				}
				if (cliente.getCelular().equals("")){
					return new ResponseEntity<>("El correo electronico es obligatorio", HttpStatus.BAD_REQUEST);
			}
				if (cliente.getDireccion().equals("")) {
					return new ResponseEntity<>("El número celular es obligatorio", HttpStatus.BAD_REQUEST);
				}
				if (cliente.getCelular().equals("")) {
					return new ResponseEntity<>("La dirección es obligatoria", HttpStatus.BAD_REQUEST);
				}
				if (cliente.getCorreo_electronico().equals("")) {
					return new ResponseEntity<>("El correo electronico es obligatori", HttpStatus.BAD_REQUEST);
				}
				if (cliente.getEstado().equals("")) {
					return new ResponseEntity<>("El estado es obligatorio", HttpStatus.BAD_REQUEST);
				}
				
				
			clienteService.save(cliente);
			return new ResponseEntity<>(cliente,HttpStatus.OK);
		}
		@GetMapping("/")
		public ResponseEntity<Object> findAll(){
			var ListaCliente=clienteService.findAll();
			return new ResponseEntity<>(ListaCliente, HttpStatus.OK);
		}
		
		@GetMapping("/busquedafiltro/{filtro}")
		public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
			var ListaCliente=clienteService.filtroCliente(filtro);
			return new ResponseEntity<>(ListaCliente, HttpStatus.OK);
		}
		
		//@PathVariable : Recibe una variable por enlace
			@GetMapping("/{id}")
			public ResponseEntity<Object> findOne(@PathVariable String id){
				var cliente=clienteService.findOne(id);
				return new ResponseEntity<>(cliente,HttpStatus.OK);
				
			}
			
			// @DeleteMapping("/eliminarPermanente/{id}")
			// public ResponseEntity<Object> delete(@PathVariable String id){
			// 	 cliente.delete(id);
			// 			return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
			// }
			@DeleteMapping("/{id_cliente}")
			public ResponseEntity<Object> delete(@PathVariable String id_cliente){
				clienteService.delete(id_cliente);
						return new ResponseEntity<>("cliente Deshabilitado",HttpStatus.OK);
			}
			

			@PutMapping("/{id}")
			public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("cliente")cliente clienteUpdate){
				var cliente = clienteService.findOne(id).get();
				if (cliente != null) {
					cliente.setTipo_documento(clienteUpdate.getTipo_documento());
					cliente.setNumero_documento(clienteUpdate.getNumero_documento());
					cliente.setPrimer_nombre(clienteUpdate.getPrimer_nombre());
					cliente.setSegundo_nombre(clienteUpdate.getSegundo_nombre());
					cliente.setPrimer_apellido(clienteUpdate.getPrimer_apellido());
					cliente.setSegundo_apellido(clienteUpdate.getSegundo_apellido());
					cliente.setCelular(clienteUpdate.getCelular());
					cliente.setDireccion(clienteUpdate.getDireccion());
					cliente.setCiudad(clienteUpdate.getCiudad());
					cliente.setCorreo_electronico(cliente.getCorreo_electronico());
					cliente.setEstado(cliente.getEstado());
				clienteService.save(cliente);
				return new ResponseEntity<>(cliente, HttpStatus.OK);
				
				}
				else {
					return new ResponseEntity<>("Error cliente no encontrado",HttpStatus.BAD_REQUEST);
				}
					
				}

		
	}

		

