package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;

import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/5-23:33
 */
public interface BookDao
{
    public void addBook(Book book);

    public void updateBook(Book book);

    public void deleteBook(String id);

    public int selectCount();

    public Book findBookInfo(String id);

    public List<Book> findAllBook();

    public void batchAddBook(List<Object[]> batchArgs);

    public void batchUpdateBook(List<Object[]> batchArgs);
}
