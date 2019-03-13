package com.example.demo;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.Module.SetupContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainControllerTest {
	
	private MockMvc mockMvc;
	
	@Before
	public void SetupContext() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new MainController()).build();
	}

	@Test
	public void test() throws Exception {
		this.mockMvc.perform(get("/"))
		.andDo(print())
		.andExpect(status().isOk());
		//.andExpect(model().attributeExists("serverTime"));
	}

}
