/**
 * 
 */

$(document).ready(function() {
  //이름 검사 정규식
  var getName= RegExp(/^[가-힣]{2,7}$/);
  //이메일 검사 정규식
  var getEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
  //비밀번호 규칙 정규식 : 영문, 숫자 혼용해서 8~20자 이내
  var getPw = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;

  $('#name').bind('input', function() {
    if ($('#name').val() == "") {
      $(this).addClass("is-invalid");
      $('#namefeedback').text('이름을 입력해 주세요.');
    } else if (!getName.test($('#name').val())) {
      $(this).addClass("is-invalid");
      $('#namefeedback').text('한글 이름으로 2~7자 입력해 주세요.');
    } else {
      $(this).removeClass("is-invalid");
      $(this).addClass("is-valid");
    }
  });
  
  $('#email').bind('input', function() {
    if ($('#email').val() == "") {
	  $(this).addClass("is-invalid");
	  $('#emailfeedback').text('이메일을 입력해 주세요.');
    } else if (!getEmail.test($('#email').val())) {
	  $(this).addClass("is-invalid");
	  $('#emailfeedback').text('올바른 이메일 형식에 맞게 입력해 주세요.');
	} else {
	  $(this).removeClass("is-invalid");
	  $(this).addClass("is-valid");
	}
  });
  
  $('#pw').bind('input', function() {
    if ($('#pw').val() == "") {
      $(this).addClass("is-invalid");
      $('#pwfeedback').text('비밀번호를 입력해 주세요.');
    } else if (!getPw.test($('#pw').val())) {
      $(this).addClass("is-invalid");
      $('#pwfeedback').text('숫자와 영문자 조합으로 8~20자 입력해 주세요.');
    } else {
      $(this).removeClass("is-invalid");
  	  $(this).addClass("is-valid");
    }
  });
  
  $('#chkpw').bind('input', function() {
    if ($('#pw').val() != $('#chkpw').val()) {
      $(this).addClass("is-invalid");
      $('#chkpwfeedback').text('비밀번호가 일치하지 않습니다.');
    } else {
      $(this).removeClass("is-invalid");
      $(this).addClass("is-valid");
    }
  });
  
  $('#joinsubmit').click(function(event) {
	var name = $('#name').val();
	var nameLen = name.length;
	  
    if (nameLen < 1) {
	  $('#name').addClass("is-invalid");
	  $('#namefeedback').text('이름을 입력해 주세요.');
	  event.preventDefault();
	} else if (!getName.test($('#name').val())) {
	  $('#name').addClass("is-invalid");
	  $('#namefeedback').text('한글 이름으로 2~7자 입력해 주세요.');
	  event.preventDefault();
	} else {
	  $('#name').removeClass("is-invalid");
	  $('#name').addClass("is-valid");
	}
    
    var email = $('#email').val();
    var emailLen = email.length;

	if (emailLen < 1) {
	  $('#email').addClass("is-invalid");
	  $('#emailfeedback').text('이메일을 입력해 주세요.');
	  event.preventDefault();
	} else if (!getEmail.test($('#email').val())) {
	  $('#email').addClass("is-invalid");
	  $('#emailfeedback').text('올바른 이메일 형식에 맞게 입력해 주세요.');
	  event.preventDefault();
	} else {
	  $('#email').removeClass("is-invalid");
	  $('#email').addClass("is-valid");
	}
	
	var pw = $('#pw').val();
	var pwLen = pw.length;
	
	if (pwLen < 1) {
	  $('#pw').addClass("is-invalid");
	  $('#pwfeedback').text('비밀번호를 입력해 주세요.');
	  event.preventDefault();
	} else if (!getPw.test($('#pw').val())) {
	  $('#pw').addClass("is-invalid");
	  $('#pwfeedback').text('숫자와 영문자 조합으로 8~20자 입력해 주세요.');
	  event.preventDefault();
	} else {
	  $('#pw').removeClass("is-invalid");
	  $('#pw').addClass("is-valid");
	}
	
	var chkpw = $('#chkpw').val();
	var chkpwLen = chkpw.length;
	
	if (chkpwLen < 1) {
	  $('#chkpw').addClass("is-invalid");
	  $('#chkpwfeedback').text('비밀번호를 입력해 주세요.');
	  event.preventDefault();
	} else if ($('#pw').val() != $('#chkpw').val()) {
	  $('#chkpw').addClass("is-invalid");
	  $('#chkpwfeedback').text('비밀번호가 일치하지 않습니다.');
	  event.preventDefault();
	} else {
	  $('#chkpw').removeClass("is-invalid");
	  $('#chkpw').addClass("is-valid");
	}
  });
});

function checkEmailWindow() {
  //이메일 검사 정규식
  var getEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	
  var email = $('#email').val();
  var emailLen = email.length;
  
  if (emailLen < 1) {
    alert("이메일을 입력해 주세요.");
    return false;
  } else if (!getEmail.test($('#email').val())) {
    alert("올바른 이메일 형식에 맞게 입력해 주세요.");
    return false;
  } else {
	var url = "emailcertificationForm.do?useremail=" + email;
	window.open(url, "", "width=500, height=300, left=700, top=350");
  }
  
}