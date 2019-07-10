<%--
  Created by IntelliJ IDEA.
  User: zr
  Date: 2019/6/24
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyUI/css/demo.css">
    <script src="js/jquery-1.8.3.min.js"></script>
    <!--jquery.easyui.min.js包含了easyUI中的所有插件-->
    <script src="js/jquery.easyui.min.js"></script>
</head>
<body>
<input type="button" id="but1" value="查询">
<div id="div1"> </div>
</body>
<script>
    $(function () {
       $("#but1").click(function () {
           $('#div1').datagrid({
               title:'学生信息',
               striped: true,
               url:'ccc',
               rownumbers: true,
               pagination:true,
               pageList:[1,2,3],
               pageSize:2,
               columns:[[
                   {field:'id',title:'编号',width:100},
                   {field:'name',title:'姓名',width:100},
                   {field:'sex',title:'性别',width:100,align:'right'},
                   {field:'age',title:'年龄',width:100,align:'right'},
                   {field:'birthday',title:'生日',width:100,align:'right',formatter: function(value,row,index){
                           var date=new Date(value);
                           var year=date.getFullYear();
                           var mouth=date.getMonth()+1;
                           var day=date.getDate()
                           return year+"年"+mouth+"月"+day+"日";
                       }
                       },
                   {field:'address',title:'地址',width:100,align:'right'}
                   /*{field:"aclass",title:"班级",align:"center",width:80,formatter: function(value,row,index){
                       return row.aclass.classname;
                       }}*/

               ]]
           });

       });
    });
</script>
</html>
