package com.rightside.loja;



import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.rightside.loja.models.Categoria;
import com.rightside.loja.resources.CategoriaResource;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoriaResourceTest {
	private MockMvc mockMvc;
	
	@InjectMocks
	private CategoriaResource categoriaResource;
	

	
	@Before()
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(categoriaResource)
				.build();
	}
	
	@Test 
	public void criarCategora() throws Exception {
		
		Categoria categoria = new Categoria();
		categoria.setNome("teste");
		categoria.setDescricao("aa");
		
		Gson gson = new Gson();
		
        this.mockMvc.perform(post("/categoria")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(categoria))
                .accept(MediaType.APPLICATION_JSON))
        
        .andExpect(jsonPath("$nome", is("teste")));
        
        
       
      
    }
	
	@Test
	public void testListaCategorias() throws Exception {
		
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.get("/categorias"));

		response.andExpect(MockMvcResultMatchers.status().isOk());
		response.andExpect(jsonPath("$.nome", Matchers.is("celular")));
				
				
	}

}
