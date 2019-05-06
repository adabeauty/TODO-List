<%@ page import="com.zjky.webapps.entity.TodoEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: wh
  Date: 2019/4/12
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Todo List Management</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/home.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="todo-input">
            <form class="navbar-form navbar-left" role="search" action="/todo/creation" method="post">
                <div class="form-group">
                    <span>Todo</span>
                    <input type="text" class="form-control" placeholder="Add todo" name="todoName">
                </div>
                <button type="submit" class="btn btn-default">Add</button>
            </form>
        </div>
    </nav>
    <div class="todo-panels">
        <%
            Map todos = (Map)request.getAttribute("todos");
            List<TodoEntity> ongoingTodos = (List<TodoEntity>) todos.get("ongoing");
            List<TodoEntity> doneTodos = (List<TodoEntity>) todos.get("done");
        %>
        <div class="panel panel-primary" id="ongoing-panel">
            <div class="panel-heading">Ongoing List</div>
            <div class="panel-body" id="ongoing-panel-body">
                <% for (TodoEntity ongoingTodo: ongoingTodos) {%>
                <div class="input-group" id="<%= ongoingTodo.getId() %>">
                    <input class="todoCheckbox" type="checkbox" aria-label="...">
                    <%= ongoingTodo.getName() %>
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                </div>
                <%}%>
            </div>
        </div>
        <div class="panel panel-success" id="done-panel">
            <div class="panel-heading">Done List</div>
            <div class="panel-body" id="done-panel-body">
                <% for (TodoEntity doneTodo: doneTodos) {%>
                <div class="input-group">
                    <%= doneTodo.getName() %>
                </div>
                <%}%>
            </div>
        </div>
    </div>

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script src="/js/home.js"></script>
</body>
</html>
