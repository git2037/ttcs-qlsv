<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title><dec:title default="Error"/></title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
      margin: 0;
      padding: 0;
    }

    .container {
      max-width: 500px;
      margin: 100px auto;
      text-align: center;
    }

    h1 {
      color: #333333;
    }

    p {
      color: #666666;
      line-height: 1.5;
    }
  </style>
</head>
<body>
<div class="container">
  <dec:body/>
</div>
</body>
</html>