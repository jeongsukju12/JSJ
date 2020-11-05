package com.mycompany.mysite;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.mysite.service.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	public MemberMapper memberMapper;
	
	int emailcount = 0;
	
	//회원가입 폼
	@RequestMapping(value = "/joinForm.do")
	public String joinForm() {
		return "join/joinForm";
	}
	
	//회원가입 실행
	/*@RequsetMapping(value = "/joinExecution.do")
	public String joinExecution() {
		
	}*/
	
	//이메일 인증하기 폼
	@RequestMapping(value = "/emailcertificationForm.do")
	public String emailcertificationForm(HttpServletRequest req) {
		String useremail = req.getParameter("useremail");
		req.setAttribute("email", useremail);
		return "join/emailcertification";
	}
	
	//이메일 인증번호 보내기
	@RequestMapping(value = "/emailcertification.do")
	public ModelAndView emailcertification(HttpServletRequest req, HttpServletResponse resp, String useremail) throws IOException {
		Random r = new Random();
		int dice = r.nextInt(4589362) + 49311;
		
		String setfrom = "jeongsukju12@gmail.com";
		String tomail = req.getParameter("useremail"); //받는 사람 이메일
		String title = "회원가입 인증 이메일 입니다."; //제목
		String content =
		
		System.getProperty("line.separator") + //한줄씩 줄간격을 두기 위해 작성
		System.getProperty("line.separator") + 
		"안녕하세요. 회원님 저희 홈페이지를 찾아주셔서 감사합니다."
		+ System.getProperty("line.separator") + 
		System.getProperty("line.separator") + 
		" 인증번호는 " + dice + "입니다." 
		+ System.getProperty("line.separator") +
		System.getProperty("line.separator") +
		"받으신 인증번호를 홈페이지에 입력해 주시면 다음으로 넘어갑니다.";
		
		try {
		  MimeMessage message = mailSender.createMimeMessage();
		  MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
		  
		  messageHelper.setFrom(setfrom); //보내는사람 생략하면 정상작동을 안함
		  messageHelper.setTo(tomail); //받는사람 이메일
		  messageHelper.setSubject(title); //메일 제목은 생략이 가능하다
		  messageHelper.setText(content); //메일 내용
		  
		  mailSender.send(message);
		} catch (Exception e) {
		  System.out.println(e);
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("join/emailcertification");
		mv.addObject("dice", dice);
		mv.addObject("email", tomail);
		
		System.out.println("mv : " + mv);
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out_email = resp.getWriter();
		out_email.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
		out_email.flush();
		
		return mv;
	}
	
	@RequestMapping(value = "/emailcertificationEnter.do{dice}")
	public ModelAndView emailcertificationEnter(String certificationnumber, String useremail, @PathVariable String dice, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("마지막 : certificationnumber : " + certificationnumber);
		System.out.println("마지막 : dice : " + dice);
		
		//페이지 이동과 자료를 동시에 하기 위해 ModelAndView를 사용해서 이동할 페이지와 자료를 담음
		ModelAndView mv = new ModelAndView();
		
		if (certificationnumber.equals(dice)) {
			emailcount = 1;
			//인증번호가 일치할 경우 인증번호가 맞다는 창을 출력하고 회원가입창으로 이동함
			mv.setViewName("join/joinForm");
			mv.addObject("e_mail", certificationnumber);
			mv.addObject("emailcount", emailcount);
			
			//만약 인증번호가 같다면 이메일을 한번 더 입력할 필요가 없게 한다.
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = resp.getWriter();
			out_equals.println("<script>alert('인증번호가 일치하였습니다. 회원가입창으로 이동합니다.'); window.close();</script>");
			out_equals.flush();
			
			return mv;
			
		} else if (certificationnumber != dice) {
			String tomail = req.getParameter("useremail");
			ModelAndView mv2 = new ModelAndView();
			mv2.setViewName("join/emailcertification");
			mv2.addObject("email", tomail);
			
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = resp.getWriter();
			out_equals.println("<script>alert('인증번호가 일치하지 않습니다. 인증번호를 다시 입력해 주세요.');</script>");
			out_equals.flush();
			
			return mv2;
		}
		
		return mv;
	}

}
