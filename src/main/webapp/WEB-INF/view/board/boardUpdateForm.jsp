<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h4  class="text-center">게시판 수정</h4>
<form class="container"  action="boardUpdatePro"   method="post"    enctype="multipart/form-data"    >
  <input type="hidden"  name="pnum"  value="${board.pnum }">
   <input type="hidden"  name="originfile"  value="${board.file1 }">
  <div class="form-group">
    <label for="name">작성자:</label>
    <input type="text" class="form-control" placeholder="Enter name" id="pname"    name="pname"   value="${board.pname }">
  </div>
  <div class="form-group">
    <label for="pwd">비밀번호:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd"  name="pass">
  </div>
  
    <div class="form-group">
    <label for="price">판매가격:</label>
    <input type="text" class="form-control" placeholder="" id="price"  name="price" value=${board.price }>
  </div>
  
  
  <div class="form-group">
    <label for="subject">제목:</label>
    <input type="text" class="form-control" placeholder="Enter password" id="subject"  name="subject"  value="${board.subject }">
  </div>
  
  <div class="form-group">
  <label for="content">내용:</label>
  <textarea class="form-control" rows="5" id="content"   name="content">${board.content }</textarea>
</div>
<div class="form-group">
    <label for="file">파일:</label>
    <input type="file" class="form-control"  id="file"  name="file1">
  </div>

  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>