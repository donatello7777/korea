package com.mbc.left4dead;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@Autowired//쿼리가 실행 시 자동으로 호출(연결)
	SqlSession sqlSession;
	
	@RequestMapping(value = "/")
	public String home() 
	{
		return "main";
	}
	@RequestMapping(value = "/input")//메뉴에서 자료입력 클릭하면 인풋으로 가라는 뜻
	public String text1()
	{
		 return "input2";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	//입력화면에서 자료입력 후 전송버튼을 누르면 "save"라는 목적지로 이동..
	//목적지는save가 되고 메소드는 post가 된다.
	public String text2(HttpServletRequest request,Model model)
	//HttpServletRequest수동으로 지정(컨+스페이스)이 필요! request입력! && Model(1번째_전송방식) 수동으로 지정(컨+스페이스) 후 model입력!
	{
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		int kor=Integer.parseInt(request.getParameter("kor"));
		int eng=Integer.parseInt(request.getParameter("eng"));
		int mat=Integer.parseInt(request.getParameter("mat"));//이름,나이,국어,영어,수학 값을 받아옴
		model.addAttribute("name", name);//String타입형식 addAttribute();
		model.addAttribute("kor", kor);//String타입형식 addAttribute();
		model.addAttribute("eng", eng);//String타입형식 addAttribute();
		model.addAttribute("mat", mat);//String타입형식 addAttribute();
		model.addAttribute("age", age);//String타입형식 addAttribute();
		//넘겨받은 자료를 마이바티스 기술을 이용하여 저장
		Service ss=sqlSession.getMapper(Service.class);
		ss.insertm(name,kor,eng,mat,age);
		return "redirect:/";//@RequestMapping(value = "/")의 위치로 설정함
	}
	//출력버튼을 클릭하면
	@RequestMapping(value = "/out")
	public String text3(Model model)//(1번째_전송방식)
	{
		Service ss = sqlSession.getMapper(Service.class);
		ArrayList<ScoreDTO> list = ss.out2();
		model.addAttribute("list", list);
		return "out";
	}
}
