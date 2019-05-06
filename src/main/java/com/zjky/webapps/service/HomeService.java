package com.zjky.webapps.service;

import com.zjky.webapps.dao.TodoDao;
import com.zjky.webapps.entity.TodoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeService {
    @Autowired
    private TodoDao todoDao;

    public Map getTodos() {
        List<TodoEntity> todos = todoDao.get();
        Map sortedTodos = new HashMap<String, List<TodoEntity>>();
        List<TodoEntity> ongoingTodos = new ArrayList<>();
        List<TodoEntity> doneTodos= new ArrayList<>();
        for (TodoEntity todo: todos) {
            if (todo.getStatus() == 0) {
                ongoingTodos.add(todo);
            }
            if (todo.getStatus() == 1) {
                doneTodos.add(todo);
            }
        }
        sortedTodos.put("ongoing", ongoingTodos);
        sortedTodos.put("done", doneTodos);

        return sortedTodos;
    }

    public String addTodo(String name) {
        TodoEntity todo = new TodoEntity();
        todo.setName(name);
        todo.setPriority(1);
        todo.setStatus(0);
        todoDao.insert(todo);
        return "Success";
    }

    public void updateTodoStatus(int id) {
        TodoEntity todo = new TodoEntity();
        todo.setId(id);
        todoDao.updateStatus(todo);
    }

    public void deleteTodo(int id) {
        TodoEntity todo = new TodoEntity();
        todo.setId(id);
        todoDao.deleteTodo(todo);
    }
}
