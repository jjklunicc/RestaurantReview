<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드</title>

</head>
 	 
 <body>
  	 <form action="/ReviewService/test_fileUpload.do" id="fileUpload" name="fileUpload" method="post" enctype="multipart/form-data">
			업로드 ID : <input type="text" name="id"><br>
			파일 : <input type="file" name="file"><br>
		<input type="submit" name="업로드" value="업로드"><br>
	 </form>
 </body>

</body>
</html>