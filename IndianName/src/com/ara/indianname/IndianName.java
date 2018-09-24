package com.ara.indianname;

import java.util.Scanner;

public class IndianName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요.");
		String name = kb.nextLine();
		
		System.out.println("생년을 입력하세요");
		String birthYear = kb.next();
		
		System.out.println("생월을 입력하세요");
		String birthMonth = kb.next();
		
		System.out.println("생일을 입력하세요");
		String birthDay = kb.next();
		
		String yearStr = null;
		String monthStr =null;
		String dayStr = null;
		
		if(birthYear.charAt(3) == '0') {
			yearStr = "시끄러운, 말 많은";
		} else if(birthYear.charAt(3)== '1') {
			yearStr = "푸른";
		} else if(birthYear.charAt(3) == '2') {
			yearStr = "어두운, 적색";
		}else if(birthYear.charAt(3) == '3') {
			yearStr = "조용한";
		}else if(birthYear.charAt(3) == '4') {
			yearStr = "웅크린";
		}else if(birthYear.charAt(3) == '5') {
			yearStr = "백색";
		}else if(birthYear.charAt(3) == '6') {
			yearStr = "지혜로운";
		}else if(birthYear.charAt(3) == '7') {
			yearStr = "용감한";
		}else if(birthYear.charAt(3) == '8') {
			yearStr = "날카로운";
		}else if(birthYear.charAt(3) == '9') {
			yearStr = "욕심많은";
		}
		

	
		
		
		if(birthMonth == "1") {
			monthStr = "늑대";
		} else if(birthMonth == "2") {
			monthStr = "태양";
		} else if(birthMonth == "3") {
			monthStr = "양";
		} else if(birthMonth == "4") {
			monthStr = "매";
		}else if(birthMonth == "5") {
			monthStr = "황소";
		} else if(birthMonth == "6") {
			monthStr = "불꽃";
		}else if(birthMonth == "7") {
			monthStr = "나무";
		} else if(birthMonth == "8") {
			monthStr = "달빛";
		}else if(birthMonth == "9") {
			monthStr = "말";
		} else if(birthMonth == "10") {
			monthStr = "돼지";
		}else if(birthMonth == "11") {
			monthStr = "하늘";
		} else if(birthMonth == "12") {
			monthStr = "바람";
		}
		
		System.out.println(monthStr);
		
		
		if(birthDay == "1") {
			dayStr = "~와(과) 함께 춤을";
		} else if(birthDay == "2") {
			dayStr = "~의 기상";
		} else if(birthDay == "3") {
			dayStr = "~은(는) 그림자 속에";
		} else if(birthDay == "4") {
			dayStr = null;
		} else if(birthDay == "5") {
			dayStr = null;
		} else if(birthDay == "6") {
			dayStr = null;
		} else if(birthDay == "7") {
			dayStr = "~의 환생";
		} else if(birthDay == "8") {
			dayStr = "~의 죽음";
		} else if(birthDay == "9") {
			dayStr = "~아래에서";
		} else if(birthDay == "10") {
			dayStr = "~을(를) 보라";
		} else if(birthDay == "11") {
			dayStr = "~이(가) 노래하다";
		} else if(birthDay == "12") {
			dayStr = "~의 그늘, 그림자";
		}else if(birthDay == "13") {
			dayStr = "~의 일격";
		} else if(birthDay == "14") {
			dayStr = "~에게 쫓기는 남자";
		} else if(birthDay == "15") {
			dayStr = "~의 행진";
		}else if(birthDay == "16") {
			dayStr = "~의 왕";
		} else if(birthDay == "17") {
			dayStr = "~의 유령";
		} else if(birthDay == "18") {
			dayStr = "~을 죽인 자";
		}else if(birthDay == "19") {
			dayStr = "~은(는) 맨날 잠잔다";
		} else if(birthDay == "20") {
			dayStr = "~처럼..";
		} else if(birthDay == "21") {
			dayStr = "~의 고향";
		}else if(birthDay == "22") {
			dayStr = "~의 전사";
		} else if(birthDay == "23") {
			dayStr = "은(는) 나의 친구";
		} else if(birthDay == "24") {
			dayStr = "~의 노래";
		}else if(birthDay == "25") {
			dayStr = "~의 정령";
		} else if(birthDay == "26") {
			dayStr = "~의 파수꾼";
		} else if(birthDay == "27") {
			dayStr = "~의 악마.";
		}else if(birthDay == "28") {
			dayStr = "~와(과) 같은 사나이";
		} else if(birthDay == "29") {
			dayStr = "~의 심판자, ~을(를) 쓰러트린 자";
		} else if(birthDay == "30") {
			dayStr = "~의 혼";
		}else if(birthDay == "31") {
			dayStr = "~은(는) 말이 없다";
		}				
			
		
		System.out.println(birthYear + "년 " + birthMonth + "월 " + birthDay + "일날 태어난 " + name + "님의 인디언식 이름은 " + yearStr + " " + monthStr + " " + dayStr + " " + "입니다.");
		
	}
	

	

}
