package com.atguigu.spring5.dao;

import com.atguigu.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author Shan Cheng
 * @date 2021/2/5-23:33
 */

@Repository
public class BookDaoImpl implements BookDao
{
    // 注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加的方法
    // 使用JdbcTemplate对象中的update方法
    @Override
    public void addBook(Book book)
    {
        String sql = "INSERT INTO t_book VALUES(?, ?, ?)";
        Object[] args = {book.getUserId(), book.getUserName(), book.getUserStatus()};

        int update = jdbcTemplate.update(sql, args);

        System.out.println(update);


    }

    @Override
    public void updateBook(Book book)
    {
        String sql = "UPDATE t_book SET userName=?, userStatus=? WHERE userId=?";

        Object[] args = {book.getUserName(), book.getUserStatus(), book.getUserId()};

        int update = jdbcTemplate.update(sql, args);

        System.out.println(update);
    }

    @Override
    public void deleteBook(String id)
    {
        String sql = "DELETE FROM t_book WHERE userId=?";

        int update = jdbcTemplate.update(sql, id);

        System.out.println(update);

    }

    @Override
    public int selectCount()
    {
        String sql = "SELECT COUNT(*) FROM t_book";

        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Book findBookInfo(String id)
    {
        String sql = "SELECT * FROM t_book WHERE userId=?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
    }

    @Override
    public List<Book> findAllBook()
    {
        String sql = "SELECT * FROM t_book";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs)
    {
        String sql = "INSERT INTO t_book VALUES(?, ?, ?)";

        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);

        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs)
    {
        String sql = "UPDATE t_book SET userName=?, userStatus=? WHERE userId=?";

        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);

        System.out.println(Arrays.toString(ints));
    }
}