package CoronaSystem.UserInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;

import Addon.BubbleBorder;
import Addon.MyColor;
import Addon.MyUtility;
import javax.swing.JButton;

public class LoginGUI extends JFrame{

	private int frameWidth = 500;
	private int frameHeight = 400;
	private JTextField tf_id;
	private JPasswordField tf_pw;
	private JButton btn_findPassword;
	
	public LoginGUI() {
		setResizable(false);
		Toolkit tk = Toolkit.getDefaultToolkit(); //사용자의 화면 크기값을 얻기위한 툴킷 클래스
		
		setSize(frameWidth,frameHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new JFrameWindowClosingEventHandler()); //창 닫기 이벤트
		setBounds((int) tk.getScreenSize().getWidth() / 2 - frameWidth /2, (int) tk.getScreenSize().getHeight() / 2 - frameHeight/2, frameWidth, frameHeight);
		
		setTitle("코로나 관리 시스템 - 로그인");
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(MyColor.ALICEBLUE);
		
		//둥근 모서리
		AbstractBorder brdr = new BubbleBorder(Color.BLACK,2,16,0);
		
		//리소스 미리 불러오기
		URL titleIconSrc = LoginGUI.class.getResource("/resources/titleIcon.png");
		ImageIcon titleIcon = MyUtility.resizeImage(new ImageIcon(titleIconSrc), 70, 70);
		setIconImage(titleIcon.getImage());
		
		URL logoSrc = LoginGUI.class.getResource("/resources/logo.png");
		ImageIcon logoIcon = MyUtility.resizeImage(new ImageIcon(logoSrc), 70, 70);
		
		URL finderSrc = LoginGUI.class.getResource("/resources/finder.png");
		ImageIcon finderIcon = MyUtility.resizeImage(new ImageIcon(finderSrc), 20, 20);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBounds(80, 167, 340, 150);
		getContentPane().add(centerPanel);
		centerPanel.setLayout(null);
		centerPanel.setBackground(MyColor.LIGHTSKY);
		
		JLabel lb_adminLogin = new JLabel("관리자 로그인");
		lb_adminLogin.setForeground(MyColor.PLUSIANBLUE);
		lb_adminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lb_adminLogin.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lb_adminLogin.setBounds(70, 10, 200, 30);
		centerPanel.add(lb_adminLogin);
		centerPanel.setBorder(new LineBorder(MyColor.PLUSIANBLUE));
		
		JLabel lb_id = new JLabel("ID");
		lb_id.setForeground(MyColor.PLUSIANBLUE);
		lb_id.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lb_id.setBounds(35, 65, 25, 20);
		centerPanel.add(lb_id);
		
		tf_id = new JTextField();
		tf_id.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_id.setBounds(90, 65, 220, 25);
		centerPanel.add(tf_id);
		tf_id.setColumns(10);
		tf_id.setBackground(MyColor.LIGHTGRAY);
		tf_id.setForeground(Color.black);
		tf_id.setBorder(new LineBorder(MyColor.WHITE, 2));	
		tf_id.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if(event.getKeyCode() == 10) { // 엔터키 키를 눌렀으면
                	//tryLogin();
                }
            }
        });
		
		tf_pw = new JPasswordField();
		tf_pw.setHorizontalAlignment(SwingConstants.RIGHT);
		tf_pw.setBounds(90, 100, 220, 25);
		tf_pw.setEchoChar('*'); //해당 칸에는 입력시 * 로 표시함
		tf_pw.setColumns(10);
		tf_pw.setBackground(MyColor.LIGHTGRAY);
		tf_pw.setForeground(Color.black);
		tf_pw.setBorder(new LineBorder(MyColor.WHITE, 2));	
		tf_pw.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if(event.getKeyCode() == 10) { // 엔터키 키를 눌렀으면
                	//tryLogin();
                }
            }
        });
		centerPanel.add(tf_pw);
		
		JLabel lblPw = new JLabel("PW");
		lblPw.setForeground(MyColor.PLUSIANBLUE);
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblPw.setBounds(35, 100, 45, 20);
		centerPanel.add(lblPw);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(124, 40, 260, 90);
		getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		titlePanel.setBackground(MyColor.STEELBLUE);
		titlePanel.setBorder(brdr);
		
		JLabel lb_icon_logo = new JLabel(logoIcon);
		lb_icon_logo.setBounds(12, 10, 70, 70);
		titlePanel.add(lb_icon_logo);
		
		JLabel lb_titleTop = new JLabel("Confirmed case -");
		lb_titleTop.setForeground(Color.WHITE);
		lb_titleTop.setHorizontalAlignment(SwingConstants.LEFT);
		lb_titleTop.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lb_titleTop.setBounds(94, 17, 250, 20);
		titlePanel.add(lb_titleTop);
		
		JLabel lb_titleBottom = new JLabel("human traffic");
		lb_titleBottom.setForeground(Color.WHITE);
		lb_titleBottom.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lb_titleBottom.setHorizontalAlignment(SwingConstants.CENTER);
		lb_titleBottom.setBounds(62, 47, 250, 20);
		titlePanel.add(lb_titleBottom);
		
		btn_findPassword = new JButton("Password 찾기");
		btn_findPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		btn_findPassword.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn_findPassword.setBounds(350, 338, 130, 25);
		btn_findPassword.setOpaque(false);
		btn_findPassword.setBorder(null);
		btn_findPassword.setContentAreaFilled(false);
		btn_findPassword.setFocusable(false);
		btn_findPassword.setIcon(finderIcon);
		getContentPane().add(btn_findPassword);
		
		//JLabel lb_icon_finder = new JLabel(finderIcon);
		//lb_icon_finder.setBounds(358, 339, 20, 25);
		//getContentPane().add(lb_icon_finder);
		
		setVisible(true);	
	}
	
	
	
	
	private class JFrameWindowClosingEventHandler extends WindowAdapter { //창 닫기시
		public void windowClosing(WindowEvent e) {
			if(e.getWindow() instanceof LoginGUI) { //홈 화면 닫으면
				System.exit(0); //프로그램 종료
			}	
		}
	}
}
