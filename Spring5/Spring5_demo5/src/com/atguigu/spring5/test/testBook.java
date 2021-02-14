package com.atguigu.spring5.test;

import com.atguigu.spring5.entity.Book;
import com.atguigu.spring5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/6-11:11
 */
public class testBook
{
    @Test
    public void testJdbcTemplate()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        BookService bookService = context.getBean("bookService", BookService.class);

        // 添加
//        Book book1 = new Book();
//        book1.setUserId("1");
//        book1.setUserName("Java");
//        book1.setUserStatus("a");
//
//        bookService.addBook(book1);

        // 修改
//        Book book2 = new Book();
//        book2.setUserId("1");
//        book2.setUserName("JavaUpUp");
//        book2.setUserStatus("atguigu");
//
//        bookService.updateBook(book2);

        // 删除
//        bookService.deleteBook("1");

        // 返回某个值
//        int count = bookService.selectCount();
//        System.out.println(count);

        // 查询返回单个对象
//        Book book = bookService.findOne("1");
//        System.out.println(book);

        // 查询返回对象集合
//        List<Book> bookList = bookService.findAll();
//        System.out.println(bookList);

        // 批量添加
//        List<Object[]> batchArgs = new ArrayList<>();
//
//        Object[] o1 = {"6", "Java2", "s"};
//        Object[] o2 = {"7", "C++2", "ss"};
//
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//
//        bookService.batchAdd(batchArgs);

        // 批量修改
        List<Object[]> batchArgs = new ArrayList<>();

        Object[] o1 = {"PHP", "b", "6"};
        Object[] o2 = {"Ruby", "c", "7"};

        batchArgs.add(o1);
        batchArgs.add(o2);

        bookService.batchUpdate(batchArgs);
    }
 }