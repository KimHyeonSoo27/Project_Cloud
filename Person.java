package LoginSystem;

class Person {
	String id, pw, name, call, type;
	
	public Person(String id, String pw, String name, String call, String type) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.call = call;
		this.type = type;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "아이디 :" + id + ", 비밀번호 : " + pw + ", 이름 : " + name + ", 연락처 : " + call + "가입유형 : " + type;
	}
}