<%@ page import="java.util.List" %>
<%@ page import="com.example.demo2.resource.model.Nhanvien" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/10/2024
  Time: 12:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
    <style>
        table{
            width: 100%;
            border-collapse: collapse;
        }
        th,td{
            border: 1px solid;
            text-align: left;
            padding: 8px;
        }
    </style>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>Teen phòng ban</th>
            <th>Ma nhan vien</th>
            <th>Ten nhan vien</th>
            <th>Email</th>
            <th>Sdt</th>
            <th>Dia Chi</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <% List<Nhanvien> nhanviens = (List<Nhanvien>) request.getAttribute("nhanvien");
            if (nhanviens != null) {
                for (Nhanvien nv : nhanviens){
        %>
        <tr>
            <td><%= nv.getMaphongban().getTenphongban()%></td>
            <td><%= nv.getId()%></td>
            <td><%= nv.getTennhanvien()%></td>
            <td><%= nv.getEmail()%></td>
            <td><%= nv.getDienthoai()%></td>
            <td><%= nv.getDiachi()%></td>
            <td>
                <form action="nhanvien/delete" method="post">
                    <input type="hidden" name="id" value="<%= nv.getId()%>">
                    <button type="submit">Xoa</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
        <%
            }
        %>

        </tbody>
    </table>
</body>
</html>
