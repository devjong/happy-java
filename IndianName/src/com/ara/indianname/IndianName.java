package com.ara.indianname;

import java.util.Scanner;

public class IndianName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		System.out.println("�̸��� �Է��ϼ���.");
		String name = kb.nextLine();
		
		System.out.println("������ �Է��ϼ���");
		String birthYear = kb.next();
		
		System.out.println("������ �Է��ϼ���");
		String birthMonth = kb.next();
		
		System.out.println("������ �Է��ϼ���");
		String birthDay = kb.next();
		
		String yearStr = null;
		String monthStr =null;
		String dayStr = null;
		
		if(birthYear.charAt(3) == '0') {
			yearStr = "�ò�����, �� ����";
		} else if(birthYear.charAt(3)== '1') {
			yearStr = "Ǫ��";
		} else if(birthYear.charAt(3) == '2') {
			yearStr = "��ο�, ����";
		}else if(birthYear.charAt(3) == '3') {
			yearStr = "������";
		}else if(birthYear.charAt(3) == '4') {
			yearStr = "��ũ��";
		}else if(birthYear.charAt(3) == '5') {
			yearStr = "���";
		}else if(birthYear.charAt(3) == '6') {
			yearStr = "�����ο�";
		}else if(birthYear.charAt(3) == '7') {
			yearStr = "�밨��";
		}else if(birthYear.charAt(3) == '8') {
			yearStr = "��ī�ο�";
		}else if(birthYear.charAt(3) == '9') {
			yearStr = "��ɸ���";
		}
		

	
		
		
		if(birthMonth == "1") {
			monthStr = "����";
		} else if(birthMonth == "2") {
			monthStr = "�¾�";
		} else if(birthMonth == "3") {
			monthStr = "��";
		} else if(birthMonth == "4") {
			monthStr = "��";
		}else if(birthMonth == "5") {
			monthStr = "Ȳ��";
		} else if(birthMonth == "6") {
			monthStr = "�Ҳ�";
		}else if(birthMonth == "7") {
			monthStr = "����";
		} else if(birthMonth == "8") {
			monthStr = "�޺�";
		}else if(birthMonth == "9") {
			monthStr = "��";
		} else if(birthMonth == "10") {
			monthStr = "����";
		}else if(birthMonth == "11") {
			monthStr = "�ϴ�";
		} else if(birthMonth == "12") {
			monthStr = "�ٶ�";
		}
		
		System.out.println(monthStr);
		
		
		if(birthDay == "1") {
			dayStr = "~��(��) �Բ� ����";
		} else if(birthDay == "2") {
			dayStr = "~�� ���";
		} else if(birthDay == "3") {
			dayStr = "~��(��) �׸��� �ӿ�";
		} else if(birthDay == "4") {
			dayStr = null;
		} else if(birthDay == "5") {
			dayStr = null;
		} else if(birthDay == "6") {
			dayStr = null;
		} else if(birthDay == "7") {
			dayStr = "~�� ȯ��";
		} else if(birthDay == "8") {
			dayStr = "~�� ����";
		} else if(birthDay == "9") {
			dayStr = "~�Ʒ�����";
		} else if(birthDay == "10") {
			dayStr = "~��(��) ����";
		} else if(birthDay == "11") {
			dayStr = "~��(��) �뷡�ϴ�";
		} else if(birthDay == "12") {
			dayStr = "~�� �״�, �׸���";
		}else if(birthDay == "13") {
			dayStr = "~�� �ϰ�";
		} else if(birthDay == "14") {
			dayStr = "~���� �ѱ�� ����";
		} else if(birthDay == "15") {
			dayStr = "~�� ����";
		}else if(birthDay == "16") {
			dayStr = "~�� ��";
		} else if(birthDay == "17") {
			dayStr = "~�� ����";
		} else if(birthDay == "18") {
			dayStr = "~�� ���� ��";
		}else if(birthDay == "19") {
			dayStr = "~��(��) �ǳ� ���ܴ�";
		} else if(birthDay == "20") {
			dayStr = "~ó��..";
		} else if(birthDay == "21") {
			dayStr = "~�� ����";
		}else if(birthDay == "22") {
			dayStr = "~�� ����";
		} else if(birthDay == "23") {
			dayStr = "��(��) ���� ģ��";
		} else if(birthDay == "24") {
			dayStr = "~�� �뷡";
		}else if(birthDay == "25") {
			dayStr = "~�� ����";
		} else if(birthDay == "26") {
			dayStr = "~�� �ļ���";
		} else if(birthDay == "27") {
			dayStr = "~�� �Ǹ�.";
		}else if(birthDay == "28") {
			dayStr = "~��(��) ���� �糪��";
		} else if(birthDay == "29") {
			dayStr = "~�� ������, ~��(��) ����Ʈ�� ��";
		} else if(birthDay == "30") {
			dayStr = "~�� ȥ";
		}else if(birthDay == "31") {
			dayStr = "~��(��) ���� ����";
		}				
			
		
		System.out.println(birthYear + "�� " + birthMonth + "�� " + birthDay + "�ϳ� �¾ " + name + "���� �ε��� �̸��� " + yearStr + " " + monthStr + " " + dayStr + " " + "�Դϴ�.");
		
	}
	

	

}
