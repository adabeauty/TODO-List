package com.zjky.webapps.dao;
import com.zjky.webapps.entity.TodoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoDao {
    List<TodoEntity> get();
    int insert(TodoEntity todoEntity);
    int updateStatus(TodoEntity todoEntity);
    int deleteTodo(TodoEntity todoEntity);
}
