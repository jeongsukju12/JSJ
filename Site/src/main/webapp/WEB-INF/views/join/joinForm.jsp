<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/header.jsp" %>

  <form class="formcontainer" id="contactForm" action="#">
  <fieldset>
    <h4>간편하게 가입하세요.</h4>
    <div class="form-group">
      <label for="name">Name</label>
      <input type="text" name="username" id="name" class="form-control" placeholder="홍길동">
      <div class="invalid-feedback" id="namefeedback"></div>
    </div>
    <div class="form-group">
      <label for="email">Email address</label>
      <div class="input-group">
        <input type="text" name="useremail2" id="email" class="form-control" placeholder="abc@gmail.com">
        <span class="input-group-btn">
          <button type="button" class="btn btn-primary" onclick="checkEmailWindow()">이메일 인증</button>
        </span>
        <div class="invalid-feedback" id="emailfeedback"></div>
      </div>
    </div>
    <div class="form-group">
      <label for="pw">Password</label>
      <input type="password" class="form-control" id="pw">
      <div class="invalid-feedback" id="pwfeedback"></div>
    </div>
    <div class="form-group">
      <label for="chkpw">Check Password</label>
      <input type="password" class="form-control" id="chkpw">
      <div class="invalid-feedback" id="chkpwfeedback"></div>
    </div>
    <input type="submit" class="btn btn-primary" id="joinsubmit" value="회원가입">
  </fieldset>
  </form>

<%@ include file="/WEB-INF/views/footer.jsp" %>