//package com.crud.controller;
//
//import com.crud.model.Author;
//import com.crud.model.Book;
//import com.crud.service.BookService1;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//@WebMvcTest(value = BookController1.class)
//class BookController1Test {
//
//    @MockBean
//    private BookService1 bookService ;
//
//    @Autowired
//    private MockMvc mockMvc ;
//
//    @Test
//    public void testSampleMsg1() throws Exception {
//
//        when(bookService.sample()).thenReturn("Good Morning ... !");
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/sample");
//
//        ResultActions perform = mockMvc.perform(requestBuilder);
//
//        MvcResult mvcResult = perform.andReturn();
//
//        MockHttpServletResponse response = mvcResult.getResponse();
//
//        int status = response.getStatus();
//        assertEquals(200 , status);
//    }
//
//    @Test
//    public void testSampleMsg2() throws Exception {
//
//        when(bookService.sample()).thenReturn("Good Morning ... !");
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
//
//        ResultActions perform = mockMvc.perform(requestBuilder);
//
//        MvcResult mvcResult = perform.andReturn();
//
//        MockHttpServletResponse response = mvcResult.getResponse();
//
//        int status = response.getStatus();
//        assertEquals(404 , status);
//    }
//
//    @Test
//    public void testSampleMsg3() throws Exception {
//
//        when(bookService.sample()).thenReturn("Good Morning ... !");
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/sample");
//
//        ResultActions perform = mockMvc.perform(requestBuilder);
//
//        MvcResult mvcResult = perform.andReturn();
//
//        MockHttpServletResponse response = mvcResult.getResponse();
//
//        int status = response.getStatus();
//        assertNotEquals(404 , status);
//    }
//
//    @Test
//    public void testSampleMsg5() throws Exception {
//
//        when(bookService.sample()).thenReturn("Good Morning ... !");
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
//
//        ResultActions perform = mockMvc.perform(requestBuilder);
//
//        MvcResult mvcResult = perform.andReturn();
//
//        MockHttpServletResponse response = mvcResult.getResponse();
//
//        int status = response.getStatus();
//        assertNotEquals(200 , status);
//    }
//
//    @Test
//    void saveBook1() throws Exception {
//        when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(true);
//
//        Book b = new Book(101l , "Ram" ,new
//                Author(1 , "Naveen", "ballikura" , "english"));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonObject = objectMapper.writeValueAsString(b);
//
//        // post request and Json Format
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addNewBook")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonObject);
//
//        // send Request
//        ResultActions perform = mockMvc.perform(requestBuilder);
//        MvcResult andReturn = perform.andReturn();
//        MockHttpServletResponse response = andReturn.getResponse();
//        int status = response.getStatus();
//
//        // compare the result
//        assertEquals(201 , status);
//    }
//    @Test
//    void saveBook2() throws Exception {
//        when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(false);
//
//        Book b = new Book(101l , "Ram" ,new
//                Author(1 , "Naveen", "ballikura" , "english"));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonObject = objectMapper.writeValueAsString(b);
//
//        // post request and Json Format
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addNewBook")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonObject);
//
//        // send Request
//        ResultActions perform = mockMvc.perform(requestBuilder);
//        MvcResult andReturn = perform.andReturn();
//        MockHttpServletResponse response = andReturn.getResponse();
//        int status = response.getStatus();
//
//        // compare the result
//        assertEquals(500 , status);
//    }
//    @Test
//    void updateBook1() throws Exception {
//        when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(true);
//
//        Book b = new Book(1l , "Ram" ,new
//                Author(1 , "Naveen", "ballikura" , "english"));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonObject = objectMapper.writeValueAsString(b);
//
//        // post request and Json Format
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/update/2")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonObject);
//        // send Request
//        ResultActions perform = mockMvc.perform(requestBuilder);
//        MvcResult andReturn = perform.andReturn();
//        MockHttpServletResponse response = andReturn.getResponse();
//        int status = response.getStatus();
//
//        // compare the result
//        assertEquals(200 , status);
//    }
//
//    @Test
//    void updateBook2() throws Exception {
//        when(bookService.saveBook(ArgumentMatchers.any())).thenReturn(false);
//
//        Book b = new Book(1l , "Ram" ,new
//                Author(1 , "Naveen", "ballikura" , "english"));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonObject = objectMapper.writeValueAsString(b);
//
//        // post request and Json Format
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/update/2")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonObject);
//        // send Request
//        ResultActions perform = mockMvc.perform(requestBuilder);
//        MvcResult andReturn = perform.andReturn();
//        MockHttpServletResponse response = andReturn.getResponse();
//        int status = response.getStatus();
//
//        // compare the result
//        assertEquals(200 , status);
//    }
//}