package com.javaex.memberList;

public class MemberVo {
		//필드
		private int memberNo;
		private String memberId;
		private String memberPw;
		private String memberName;
		private String phoneNumber;
		private String address;
		private int age;
		
		//생성자
		public MemberVo() {
		}
		

		public MemberVo(int memberNo, String memberName, String phoneNumber, String address, String memberId) {
			this.memberNo = memberNo;
			this.memberName = memberName;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.memberId = memberId;
		}


		public MemberVo(String memberName, String phoneNumber, String address, int age, String memberId, String memberPw) {
			this.memberId = memberId;
			this.memberPw = memberPw;
			this.memberName = memberName;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.age = age;
		}

		public MemberVo(int memberNo, String memberName, String phoneNumber, String address, int age,  String memberId, String memberPw) {
			this.memberNo = memberNo;
			this.memberName = memberName;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.age = age;
			this.memberId = memberId;
			this.memberPw = memberPw;
		}

		//메소드 - g/s
		public int getMemberNo() {
			return memberNo;
		}
		public void setMemberNo(int memberNo) {
			this.memberNo = memberNo;
		}
		public String getMemberId() {
			return memberId;
		}


		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}


		public String getMemberPw() {
			return memberPw;
		}


		public void setMemberPw(String memberPw) {
			this.memberPw = memberPw;
		}


		public String getMemberName() {
			return memberName;
		}


		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}


		public String getPhoneNumber() {
			return phoneNumber;
		}


		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public int getAge() {
			return age;
		}


		public void setAge(int age) {
			this.age = age;
		}


		//메소드 - 일반
		@Override
		public String toString() {
			return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
					+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", age=" + age + "]";
		}
		
		public void showInfo() {
			System.out.println(memberNo +"." + " 이름: " + memberName + "  전화번호: " + phoneNumber 
					+ "  주소: " + address + "  나이: " + age +"  비밀번호: " + memberPw);
			
			
		}
}
