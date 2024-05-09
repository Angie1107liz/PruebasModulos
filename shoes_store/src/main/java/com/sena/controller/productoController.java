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

import com.sena.interfacesService.IproductoService.IproductosService;
import com.sena.model.productos;



@RequestMapping("/api/v1/producto")
@RestController
@CrossOrigin
public class productoController {
@Autowired
	private IproductosService productosService;
	
	@PostMapping("/")
	public ResponseEntity<Object> save(@ModelAttribute("productos") productos productos){
			// condicion para cuando ya exista el  registro 
			  List<productos>listaProductosValidacion=productosService.filtroNombreProducto(productos.getNombre_producto());
			if(listaProductosValidacion.size()!=0){
				//ya tiene un registro activo
				return new ResponseEntity<>("El productos ya se encuentra registrado",HttpStatus.BAD_REQUEST);		
			}	
			if (productos.getNombre_producto().equals("")) {
				return new ResponseEntity<>("El tipo documento es obligatorio", HttpStatus.BAD_REQUEST);
            }
			if (productos.getDescripcion().equals("")) {
				return new ResponseEntity<>("El número de documento es obligatorio", HttpStatus.BAD_REQUEST);
            }
			if (productos.getPrecio_decimal().equals("")) {
				return new ResponseEntity<>("El primer nombre es obligatorio", HttpStatus.BAD_REQUEST);
            }
			if (productos.getPorcentaje_iva().equals("")) {
				return new ResponseEntity<>("El primer apellido es obligatorio", HttpStatus.BAD_REQUEST);
            }
			if (productos.getPorcentaje_descuento().equals("")){
				return new ResponseEntity<>("El correo electronico es obligatorio", HttpStatus.BAD_REQUEST);
        }
			if (productos.getEstado().equals("")) {
				return new ResponseEntity<>("El número celular es obligatorio", HttpStatus.BAD_REQUEST);
            }
		
			
			
		productosService.save(productos);
		return new ResponseEntity<>(productos,HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var listaProductos=productosService.findAll();
		return new ResponseEntity<>(listaProductos, HttpStatus.OK);
	}
	
	@GetMapping("/busquedafiltro/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
		var listaProductos=productosService.filtroProductos(filtro);
		return new ResponseEntity<>(listaProductos, HttpStatus.OK);
	}
	
	//@PathVariable : Recibe una variable por enlace
		@GetMapping("/{id}")
		public ResponseEntity<Object> findOne(@PathVariable String id){
			var producto=productosService.findOne(id);
			return new ResponseEntity<>(producto,HttpStatus.OK);
			
		}
		
		// @DeleteMapping("/eliminarPermanente/{id}")
		// public ResponseEntity<Object> delete(@PathVariable String id){
		// 	 cliente.delete(id);
		// 			return new ResponseEntity<>("Registro Eliminado",HttpStatus.OK);
		// }
		@DeleteMapping("/{Id_producto}")
		public ResponseEntity<Object> delete(@PathVariable String Id_producto){
			 productosService.delete(Id_producto);
					return new ResponseEntity<>("productos Deshabilitado",HttpStatus.OK);
		}
		

		@PutMapping("/{id}")
		public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("productos")productos productosUpdate){
			var producto = productosService.findOne(id).get();
			if (producto != null) {
				producto.setId_producto(productosUpdate.getId_producto());
				producto.setNombre_producto(productosUpdate.getNombre_producto());
				producto.setDescripcion(productosUpdate.getDescripcion());
				producto.setCantidad(productosUpdate.getCantidad());
				producto.setPrecio_decimal(productosUpdate.getPrecio_decimal());
				producto.setPorcentaje_iva(productosUpdate.getPorcentaje_iva());
				producto.setPorcentaje_descuento(productosUpdate.getPorcentaje_descuento());
				producto.setEstado(productosUpdate.getEstado());
			productosService.save(producto);
			return new ResponseEntity<>(producto, HttpStatus.OK);
			
			}
			else {
				return new ResponseEntity<>("Error el producto  no encontrado",HttpStatus.BAD_REQUEST);
			
			}   
				
			}

    
}

    


    
