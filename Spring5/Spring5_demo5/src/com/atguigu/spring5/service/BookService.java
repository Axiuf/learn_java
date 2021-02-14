package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.BookDao;
import com.atguigu.spring5.dao.BookDaoImpl;
import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/5-23:32
 */

@Service
public class BookService
{
    // 注入Dao
    @Autowired
    private BookDao bookDao;

    // 添加的方法
    public void addBook(Book book)
    {
        bookDao.addBook(book);
    }

    public void updateBook(Book book)
    {
        bookDao.updateBook(book);
    }

    public void deleteBook(String id)
    {
        bookDao.deleteBook(id);
    }

    public int selectCount()
    {
        return bookDao.selectCount();
    }

    public Book findOne(String id)
    {
        return bookDao.findBookInfo(id);
    }

    public List<Book> findAll()
    {
        return bookDao.findAllBook();
    }

    public void batchAdd(List<Object[]> batchArgs)
    {
        bookDao.batchAddBook(batchArgs);
    }

    public void batchUpdate(List<Object[]> batchArgs)
    {
        bookDao.batchUpdateBook(batchArgs);
    }
}