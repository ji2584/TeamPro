<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
.input-form {
	max-width: 680px;
	margin-top: 80px;
	padding: 32px;
	background: #fff;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	-webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
	box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
}
</style>
<script>
function win_upload() {
	var op = "width=500, height=150, left=50, top=150";
	open("${pageContext.request.contextPath}/member/pictureimgForm", "", op);
}

</script>

</head>
<body>
	<div class="container">
		<h4 class="text-center">판매글 입력</h4>
		<form class="container" action="boardPro" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="picture">
			<div class="form-group">
				<div class="col-md-3 mb-3">
					<label for="id">사진</label> <img src="" width="100px" height="120px"
						id="pic"> <a class="btn btn-primary  btn-block"
						href="javascript:win_upload()">사진업로드</a>
				</div>
				<label for="pname">판매상품:</label> <input type="text"
					class="form-control" placeholder="Enter name" id="pname"
					name="pname">
			</div>
			<div class="form-group">
				<label for="pass">비밀번호:</label> <input type="password"
					class="form-control" placeholder="Enter pass" id="pass" name="pass">
			</div>
			<div class="form-group">
				<label for="subject">제목:</label> <input type="text"
					class="form-control" placeholder="Enter subject" id="subject"
					name="subject">
			</div>
			<div class="form-group">
				<label for="content">내용:</label>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
			</div>
			<div class="form-group">
				<label for="file">파일:</label> <input type="file"
					class="form-control" placeholder="Enter file1" id="file"
					name="file1">
			</div>

			<button class="btn btn-primary btn-lg btn-block" type="submit">작성하기</button>
		</form>
	</div>
	<script> window.addEventListener('load', () => { const forms = document.getElementsByClassName('validation-form'); Array.prototype.filter.call(forms, (form) => { form.addEventListener('submit', function (event) { if (form.checkValidity() === false) { event.preventDefault(); event.stopPropagation(); } form.classList.add('was-validated'); }, false); }); }, false); </script>

</body>
</html>