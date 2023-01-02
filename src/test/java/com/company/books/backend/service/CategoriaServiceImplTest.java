package com.company.books.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.company.books.backend.model.Categoria;
import com.company.books.backend.model.dao.ICategoriaDao;
import com.company.books.backend.response.CategoriaResponseRest;

public class CategoriaServiceImplTest {

	@InjectMocks // con esto se dice que se inyecten todos los mock en caso de haber mas para poderocuparlas
	CategoriaServiceImpl service;
	
	@Mock //con esto se mokeo osea se clona y ya no hay necesidad de ur a una base de datos
	ICategoriaDao categoriaDao;
	
	List<Categoria> list = new ArrayList<Categoria>();
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.cargarCategorias(); //se llama este metodo antes de la prueba para inyectar los elementos con datos fijos antes de la prueba
	}
	
	@Test
	public void buscarCategoriaTest() {
		//metodos del framework mockito
		
		when(categoriaDao.findAll()).thenReturn(list);
		//se esta diciendo que si se solicita este metodo que devuelva una lista
		// y de esta manera se evita ir a la base de datos
		
		ResponseEntity<CategoriaResponseRest> response = service.buscarCategorias();
		
		assertEquals(4, response.getBody().getCategoriaResponse().getCategoria().size());
		
		//metodos de mockito
		verify(categoriaDao, times(1)).findAll();
	}
	
	public void cargarCategorias() {
		Categoria catUno = new Categoria(Long.valueOf(1), "Abarrotes", "Distintos abarrotes");
		Categoria catDos = new Categoria(Long.valueOf(1), "Lacteos", "Variedad abarrotes");
		Categoria catTres = new Categoria(Long.valueOf(1), "Bebidas", "Bebidas sin azucar");
		Categoria catCuatro = new Categoria(Long.valueOf(1), "Carnes", "Distintas Carnes");
		
		list.add(catUno);
		list.add(catDos);
		list.add(catTres);
		list.add(catCuatro);
	}
}
