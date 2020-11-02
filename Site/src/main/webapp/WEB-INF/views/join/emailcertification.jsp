<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>
  <title>이메일 인증</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.css">
</head>

<body>
  <form class="formcontainer2" id="contactForm" action="emailcertificationEnter.do${dice}">
  <h4>인증번호 확인</h4>
  <div class="form-group">
    <div class="input-group">
      <input type="text" name="useremail" id="email" class="form-control" value="${email}">
      <span class="input-group-btn">
        <button type="button" class="btn btn-primary" onclick="location.href='emailcertification.do?useremail=${email}'">이메일 인증</button>
      </span>
      <div class="invalid-feedback" id="emailfeedback"></div>
    </div>
  </div>
  <div class="form-group">
    <div class="input-group">
      <input type="text" name="certificationnumber" id="email" class="form-control" placeholder="인증번호를 입력하세요.">
      <span class="input-group-btn">
        <input type="submit" class="btn btn-primary" value="인증번호 전송">
      </span>
      <div class="invalid-feedback" id="emailfeedback"></div>
    </div>
  </div>
  </form>
  
  <script src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.js"></script>
</body>

</html>