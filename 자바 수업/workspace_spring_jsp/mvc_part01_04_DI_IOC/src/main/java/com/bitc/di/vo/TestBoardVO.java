package com.bitc.di.vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TestBoardVO {

	private int num;
	private String title;
	private String content;
	private int writer;
	
}
