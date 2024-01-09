
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
      <div class="input-form-backgroud row">
         <div class="input-form col-md-12 mx-auto">
            <h4 class="mb-3">게시판</h4>
            <table class="table">
               <tr>
                  <th>name</th>
                  <th>value</th>
               </tr>
               <tr>
                  <td>작성자</td>
                  <td>${board.pname}</td>
               <tr>
               <tr>
                  <td>파일</td>
                  <td>${board.file1}<img
                     src="${pageContext.request.contextPath}/image/board/${board.file1}"
                     width="100px" height="120px"></td>
               <tr>
               <tr>
                  <td>제목</td>
                  <td>${board.subject}</td>
               <tr>
               <tr>
                  <td>내용:${board.content}</td>
               <tr>
               <tr>
                  <td>날짜</td>
                  <td>${board.regdate}</td>
               <tr>
               <tr>
                  <td>조회수</td>
                  <td>${board.readcnt}</td>
               <tr>
               <tr>
                  <td colspan="2" class="text-right"><a class="btn btn-primary"
                     href="${pageContext.request.contextPath}/board/boardUpdateForm?num=${board.pnum}">변경</a>
                     <a class="btn btn-primary"
                     href="${pageContext.request.contextPath}/board/boardDeleteForm?num=${board.pnum}">삭제</a>
                     <a class="btn btn-primary"
                     href="${pageContext.request.contextPath}/board/boardList">목록</a>
                  </td>
               </tr>
            </table>
         
            
            
         </div> </div>
      </div>   
</body>
</html>