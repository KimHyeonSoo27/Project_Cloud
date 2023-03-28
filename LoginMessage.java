package LoginSystem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

//아이디/비밀번호 입력 후 로그인을 눌렀을 때
class LoginMessage extends JFrame {
	
	public LoginMessage(String id, String pw) {
		// TODO Auto-generated constructor stub
		
		//프레임 설정
		setTitle("메시지");
		setSize(300,120);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//컨테이너 설정
		Container contentpane = getContentPane();
		
		//Label 만들기
		JLabel message = new JLabel("아이디 : " + id + ", 비밀번호 : " + pw);
		
		//버튼 만들기
		JButton ok = new JButton("확인");
		
		//버튼 기능 설정
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				setVisible(false); //확인 누르면 창 사라짐
				
				//i) 아이디가 없을 경우 "존재하지 않는 아이디"의 메세지 창
				
				//ii) 비밀번호가 틀린경우 "비밀번호 오류"의 메세지 창
			}
		});
		
		//Panel 만들기 -> 마지막에 한 Panel에 합쳐서 붙여주기
		JPanel msg = new JPanel();
		msg.add(message);
		
		JPanel btn = new JPanel();
		btn.add(ok, SwingConstants.CENTER);
		
		JPanel p = new JPanel(new GridLayout(2,1));
		p.add(msg);
		p.add(btn);
		
		//컨텐트 팬에 버튼 붙이기
		contentpane.add(p, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
}
