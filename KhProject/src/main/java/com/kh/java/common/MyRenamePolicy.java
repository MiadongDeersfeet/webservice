package com.kh.java.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

// FileRenamePolicy 라는 인터페이스를 구현해서
// 이름바꾸기 정책을 사용
// 추상메소드 -- 정의는 되어있는데 구현이 안되어있다.
public class MyRenamePolicy implements FileRenamePolicy {
	
	// FileRenamePolicy 인터페이스가 가지고 있는 rename 추상메소드가 있음 ~
	// rename 메소드를 오버라이딩 해서 기존파일명을 전달 받아서 파일명을 수정한 뒤
	// 수정한 파일을 반환해줄 것 -- 오버라이딩이란? 상속 구조에서 부모 클래스의 메소드를 자식 클래스에서 재정의 해서 사용할 수 있는 것.
	
	@Override
	public File rename(File originFile) {
		// "aaa.jpg"
		// "bbb.jpg"
		// "ccc.jpg"
		
		// 원본파일명
		
		String originName = originFile.getName();
		
		// 우리 입맛대로 이름 바꾸기 => 최대한 이름이 안겹치도록
		// KHacademy_ 년월일시분초_ 랜덤값 + 원본 파일 확장자
		
		/*
		 * 예시)
		 * 원본파일명           바꾸기
		 * bono.jpg     =>   KHacademy_20250930163122_999.jpg
		 */
		
		// 1. 원본파일의 확장자
		String ext = originName.substring(originName.lastIndexOf(".")); // 오리진 네임에서 인덱스를 알아내야해요. // 원래는 .이 없는 파일이 들어올 수 있어서 예외처리 필요
		
		// 2. 년월일시분초
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		// 3. 랜덤숫자
		int randomNo = (int)(Math.random() * 900) + 100;
		
		// 1 + 2 + 3
		String changeName = "KHacademy_" + currentTime + "_" + randomNo + ext;
		
		// 기존 파일명을 수정된 파일명으로 적용시켜서 반환
		return new File(originFile.getParent(), changeName);
		
		/* 깨알 문자열 다루기~!
		String str = "abc";
		StringBuilder sb = new StringBuilder();
		sb.append(str); */
		
		/*
		String str = "abc";
		for(int i = str.length(); i < i--) {
			
		} */
		
		
	}
}
