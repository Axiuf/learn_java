package com.atguigu.exer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shan Cheng
 * @date 2020/12/22-16:19
 */
public class DAO<T>
{
    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity)
    {
        map.put(id, entity);
    }

    public T get(String id)
    {
        return map.get(id);
    }

    public void update(String id, T entity)
    {
        map.put(id, entity);
    }

    public List<T> list()
    {
        return (List<T>) map.values();
    }

    public void deletes(String id)
    {
        map.remove(id);
    }
}
