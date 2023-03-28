package LoginSystem;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



//회원가입 창에서 회원가입 버튼 눌렀을때
class Sign_up_btn_event extends JFrame{
	//생성자
	public Sign_up_btn_event(Person p) {
		// TODO Auto-generated constructor stub
		//프레임 설정
		setTitle("회원 가입 확인 메시지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//컨테이너 창 설정
		Container ctp = getContentPane();//컨텐트 팬을 가져온다.
		ctp.setLayout(new BorderLayout());
		
		//Label 만들기
		JLabel jl = new JLabel("ID : " + p.id + ", P/W : " + p.pw + ", name : " + p.name + ", 연락처 : " + p.call + ", type : " + p.type);
		
		//Botton 만들기
		JButton btn = new JButton("확인");
		
		//Button 기능 구현
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		//Panel 만들어서 붙이기 (버튼이면 버튼, 라벨이면 라벨 각각 만들어서 마지막에 하나의 판넬에 합치기)
		JPanel msg = new JPanel();
		msg.add(jl, SwingConstants.CENTER);
		
		JPanel jbtn = new JPanel();
		jbtn.add(btn, SwingConstants.CENTER);
		
		JPanel jp = new JPanel(new GridLayout(2,1));
		jp.add(msg);
		jp.add(jbtn);
		
		//컨텐트 팬에 Panel 붙이기
		ctp.add(jp, BorderLayout.CENTER);
		
		//크기지정 및 화면출력여부 설정
		setSize(500,120);
		setVisible(true);
	}
}

//회원가입 창
class Sign_up extends JFrame {
	ArrayList<Person> p_info;
	Search search;
	
	public Sign_up () {
		// TODO Auto-generated constructor stub
		
		//프레임 설정
		setTitle("회원 관리 시스템");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//컨테이너(창) 설정
		Container contentpane = getContentPane(); //컨텐트 팬을 가져온다.
		contentpane.setLayout(new BorderLayout()); //컨텐트 팬의 배치관리자를 BorderLayout으로 설정
		
		//Label 만들기
		JLabel main_text = new JLabel("회원가입", SwingConstants.CENTER);
		Font font = new Font("굴림 보통", Font.BOLD, 40);
		main_text.setFont(font);
		
		JLabel id = new JLabel("아이디 : ");
		JLabel pw = new JLabel("비밀번호 : ");
		JLabel name = new JLabel("이 름");
		JLabel call = new JLabel("연락처 : ");
		
		//Radio Button 만들기
		JRadioButton customer = new JRadioButton("고객");
		JRadioButton manager = new JRadioButton("관리자");
		JRadioButton etc = new JRadioButton("기타");
		
		ButtonGroup bg = new ButtonGroup(); //라디오 버튼들을 하나의 그룹으로 묶어주면 중복선택 불가능!
		bg.add(customer);
		bg.add(manager);
		bg.add(etc);
		
		//textField 만들기
		JTextField jt_id = new JTextField(10);
		JTextField jt_pw = new JTextField(10);
		JTextField jt_name = new JTextField(10);
		JTextField jt_call = new JTextField(10);
		
		//Button 만들기
		JButton signup = new JButton("회원가입");
		JButton cancle = new JButton("취소");
		
		//Button 기능 구현
		signup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(customer.isSelected()) {
					Person person = new Person(jt_id.getText(), jt_pw.getText(), jt_name.getText(), jt_call.getText(), "고객");
					new Sign_up_btn_event(person);
					if(search.isEmpty(p_info, person.id) == true) {
						p_info.add(person);
					}else {
						
					}
					
				}else if(manager.isSelected()){
					new Sign_up_btn_event(new Person(jt_id.getText(), jt_pw.getText(), jt_name.getText(), jt_call.getText(), "관리자"));
				}else {
					new Sign_up_btn_event(new Person(jt_id.getText(), jt_pw.getText(), jt_name.getText(), jt_call.getText(), "기타"));
				}
				
			}
		});
		
		cancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		//Panel 만들기
		JPanel r_btn = new JPanel();
		r_btn.add(customer);
		r_btn.add(manager);
		r_btn.add(etc);
		
		JPanel id_line = new JPanel();
		id_line.add(id);
		id_line.add(jt_id);
		
		JPanel pw_line = new JPanel();
		pw_line.add(pw);
		pw_line.add(jt_pw);
		
		JPanel name_line = new JPanel();
		name_line.add(name);
		name_line.add(jt_name);
		
		JPanel call_line = new JPanel();
		call_line.add(call);
		call_line.add(jt_call);
		
		JPanel button = new JPanel();
		button.add(signup);
		button.add(cancle);
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(6,1));
		jpanel.add(r_btn);
		jpanel.add(id_line);
		jpanel.add(pw_line);
		jpanel.add(name_line);
		jpanel.add(call_line);
		jpanel.add(button);
		
		
		//컨텐트 팬에 부착하기
		contentpane.add(main_text, BorderLayout.NORTH);
		contentpane.add(jpanel, BorderLayout.CENTER); //좌-중-우 중에 위치 선택하는 느낌(?)
		
		//크기 및 출력 여부 결정
		setSize(300,400);
		setVisible(true);
	}

}