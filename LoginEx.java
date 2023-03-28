package LoginSystem;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class LoginEx extends JFrame {
	
	public LoginEx() {
		// TODO Auto-generated constructor stub
		
		//프레임 설정
		setTitle("계정 관리 시스템");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//컨테이너(창) 설정
		Container contentpane = getContentPane(); //컨텐트 팬을 알아낸다
		contentpane.setLayout(new BorderLayout()); //컨텐트 팬에 BorderLayout 배치관리자 설정
		contentpane.setName("로그인 화면");
		
		//setLayout 말고 setBounds를 활용하면 보다 세밀한 위치 조정 가능!
		//login_text.setBounds(50, 50, 100, 100);
		
		//라벨 만들기
		JLabel login_text = new JLabel("로그인 화면",SwingConstants.CENTER);
		Font font = new Font("굴림 보통", Font.BOLD, 25);
		login_text.setFont(font);
		JLabel id = new JLabel("아이디 : ", SwingConstants.CENTER);
		JLabel pw = new JLabel("비밀번호 : ", SwingConstants.CENTER);
		
		//텍스트필드 만들기
		JTextField get_id = new JTextField(10); //괄호 안의 값으로 텍스트상자 길이 조절
		JTextField get_pw = new JTextField(10);
		
		//버튼 만들기
		JButton login = new JButton("로그인");
		JButton sigin_up = new JButton("회원가입");
		
		//버튼 기능 구현
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new LoginMessage(get_id.getText(), get_pw.getText());
			}
		});
		
		sigin_up.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Sign_up();
			}
		});
		
		//패널에 버튼 붙이기
		JPanel id_panel = new JPanel();
		id_panel.add(id);
		id_panel.add(get_id);
		
		JPanel pw_panel = new JPanel();
		pw_panel.add(pw);
		pw_panel.add(get_pw);
		
		JPanel id_pw_panel = new JPanel();
		id_pw_panel.add(id_panel);
		id_pw_panel.add(pw_panel);
		
		JPanel panel_btn = new JPanel();
		panel_btn.add(login);
		panel_btn.add(sigin_up);
		
		JPanel panel = new JPanel(new GridLayout(2,1));
		panel.add(id_pw_panel); // -> 1행
		panel.add(panel_btn); // -> 2행
		
		//컨텐트 팬에 버튼 붙이기
		contentpane.add(login_text, BorderLayout.NORTH);
		contentpane.add(panel,BorderLayout.CENTER);
		
		//크기 및 화면 출력 설정 -> 항상 마지막에!!
		setSize(300,250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginEx();
	}

}