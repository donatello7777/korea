package com.mbc.left4dead;

import java.util.ArrayList;

public interface Service 
{
	void insertm(String name, int kor, int eng, int mat, int age);

	ArrayList<ScoreDTO> out2();
	
}