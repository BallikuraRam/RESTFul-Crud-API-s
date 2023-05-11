//package com.crud.controller;
//
//import com.crud.model.Author;
//import com.crud.model.Book;
//import com.crud.service.BookService;
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
//
//@WebMvcTest(value = BookController.class)
//class BookControllerTest {
//
//    @MockBean
//    private BookService bookService;
//
//    @Autowired
//    MockMvc mockMvc;
//
//
//    @Test
//    void addNewBook1() throws Exception {
//        when(bookService.addBook(ArgumentMatchers.any())).thenReturn(new Book());
//
//        Book b = new Book(101l , "Ram" ,new
//                Author(1 , "Naveen", "ballikura" , "english"));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonObject = objectMapper.writeValueAsString(b);
//
//        // post request and Json Format
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/book")
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
//    void addNewBook2() throws Exception {
//        when(bookService.addBook(ArgumentMatchers.any())).thenReturn(new Book());
//
//        Book b = new Book(101l , "Ram" ,new
//                Author(1 , "Naveen", "ballikura" , "english"));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonObject = objectMapper.writeValueAsString(b);
//
//        // post request and Json Format
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/")
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
//        assertEquals(404 , status);
//    }
//    @Test
//    void addNewBook3() throws Exception {
//        when(bookService.addBook(ArgumentMatchers.any())).thenReturn(new Book());
//
//        Book b = new Book(101l , "Ram" ,new
//                Author(1 , "Naveen", "ballikura" , "english"));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonObject = objectMapper.writeValueAsString(b);
//
//        // post request and Json Format
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/book")
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
//        assertNotEquals(404 , status);
//    }
//
//    @Test
//    void updateBook1() throws Exception {
//        when(bookService.addBook(ArgumentMatchers.any())).thenReturn(new Book());
//
//        Book b = new Book(1l , "Ram" ,new
//                Author(1 , "Naveen", "ballikura" , "english"));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonObject = objectMapper.writeValueAsString(b);
//
//        // post request and Json Format
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/update/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonObject);
//        // send Request
//        ResultActions perform = mockMvc.perform(requestBuilder);
//        MvcResult andReturn = perform.andReturn();
//        MockHttpServletResponse response = andReturn.getResponse();
//        int status = response.getStatus();
//
//        // compare the result
//        assertEquals(404 , status);
//    }
//    @Test
//    void updateBook2() throws Exception {
//        when(bookService.addBook(ArgumentMatchers.any())).thenReturn(new Book());
//
//        Book b = new Book(1l , "Ram" ,new
//                Author(1 , "Naveen", "ballikura" , "english"));
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonObject = objectMapper.writeValueAsString(b);
//
//        // post request and Json Format
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/update/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonObject);
//        // send Request
//        ResultActions perform = mockMvc.perform(requestBuilder);
//        MvcResult andReturn = perform.andReturn();
//        MockHttpServletResponse response = andReturn.getResponse();
//        int status = response.getStatus();
//
//        // compare the result
//        assertNotEquals(200 , status);
//    }
//}