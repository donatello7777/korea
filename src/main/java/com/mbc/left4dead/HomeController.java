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
	@Autowired//������ ���� �� �ڵ����� ȣ��(����)
	SqlSession sqlSession;
	
	@RequestMapping(value = "/")
	public String home() 
	{
		return "main";
	}
	@RequestMapping(value = "/input")//�޴����� �ڷ��Է� Ŭ���ϸ� ��ǲ���� ����� ��
	public String text1()
	{
		 return "input2";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	//�Է�ȭ�鿡�� �ڷ��Է� �� ���۹�ư�� ������ "save"��� �������� �̵�..
	//��������save�� �ǰ� �޼ҵ�� post�� �ȴ�.
	public String text2(HttpServletRequest request,Model model)
	//HttpServletRequest�������� ����(��+�����̽�)�� �ʿ�! request�Է�! && Model(1��°_���۹��) �������� ����(��+�����̽�) �� model�Է�!
	{
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		int kor=Integer.parseInt(request.getParameter("kor"));
		int eng=Integer.parseInt(request.getParameter("eng"));
		int mat=Integer.parseInt(request.getParameter("mat"));//�̸�,����,����,����,���� ���� �޾ƿ�
		model.addAttribute("name", name);//StringŸ������ addAttribute();
		model.addAttribute("kor", kor);//StringŸ������ addAttribute();
		model.addAttribute("eng", eng);//StringŸ������ addAttribute();
		model.addAttribute("mat", mat);//StringŸ������ addAttribute();
		model.addAttribute("age", age);//StringŸ������ addAttribute();
		//�Ѱܹ��� �ڷḦ ���̹�Ƽ�� ����� �̿��Ͽ� ����
		Service ss=sqlSession.getMapper(Service.class);
		ss.insertm(name,kor,eng,mat,age);
		return "redirect:/";//@RequestMapping(value = "/")�� ��ġ�� ������
	}
	//��¹�ư�� Ŭ���ϸ�
	@RequestMapping(value = "/out")
	public String text3(Model model)//(1��°_���۹��)
	{
		Service ss = sqlSession.getMapper(Service.class);
		ArrayList<ScoreDTO> list = ss.out2();
		model.addAttribute("list", list);
		return "out";
	}
}
