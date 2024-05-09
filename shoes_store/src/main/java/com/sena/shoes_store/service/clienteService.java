package com.sena.shoes_store.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.shoes_store.interfaces.Icliente;
import com.sena.shoes_store.interfacesService.IclienteService;
import com.sena.shoes_store.model.cliente;






@Service

public class clienteService
implements IclienteService {

    
    @Autowired
    private Icliente data;



    @Override
    public String save(cliente cliente) {
        data.save(cliente);
		return cliente.getId_cliente();
	}

    @Override
    public List<cliente> findAll() {
        List<cliente> ListaCliente=
				(List<cliente>) data.findAll();
		//(List<cliente>) : Es un cast
		//ya que findAll() retorna un objeto distinto
		//- Retorna un iterable <cliente>
		//- se convierte a list <cliente>
		return ListaCliente;
	}

  
// la variable que almacena los registros


@Override
public List<cliente> filtroNombreCliente(String primer_nombre) {
		List<cliente>ListaCliente=data.filtroCliente(primer_nombre);
		return ListaCliente;
	}

    @Override
public List<cliente> filtroCiudadCliente(String ciudad) {
		List<cliente>ListaCliente=data.filtroCliente(ciudad);
		return ListaCliente;
	}

    @Override
    public List<cliente> filtroEstadoCliente(String estado) {
            List<cliente>ListaCliente=data.filtroCliente(estado);
            return ListaCliente;
        }




    @Override
    public List<cliente> filtroCliente(String filtro) {
        List <cliente> ListaCliente =data.filtroCliente(filtro);
        return ListaCliente;
     }
    
    @Override
    public Optional<cliente> findOne(String id) {
        Optional<cliente> cliente=data.findById(id);
		return cliente;
	}

    // @Override
	// public int delete(String id) {
	// 	data.deleteById(id);
	// 	return 1;
	// }

    @Override
    public int delete(String id_cliente) {
        var cliente=data.findById(id_cliente).get();
		cliente.setEstado("Inactivo"); 
        data.save(cliente); 
		return 0;
    }


       
}

