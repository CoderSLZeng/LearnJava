import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClient extends Frame {
	
	TextArea contentTA = new TextArea(); // 内容显示文本框
	TextField inputTF = new TextField(); // 单行文本输入框
	
	Socket socket = null;

	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

	/**
	 * 启动窗口
	 */
	private void launchFrame() {
		setLocation(400, 300); // 窗口坐标位置
		this.setSize(300, 300); // 窗口大小
		add(inputTF, BorderLayout.SOUTH);  // 上北
		add(contentTA, BorderLayout.NORTH); // 下南
		pack();
		this.addWindowListener(new WindowAdapter() { // 添加窗口监听事件

			@Override
			public void windowClosing(WindowEvent e) { // 监听窗口
				System.exit(0);
			}
			
		});
		
		inputTF.addActionListener(new TextFieldActinonListener()); // 给文本输入框添加监听事件
		setVisible(true); // 显示窗口		
		connect();
	}
	
	public void connect() {
		try {
			socket = new Socket("127.0.0.1", 8888);
System.out.println("connected");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * TextField 事件监听内部类
	 */
	private class TextFieldActinonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String inputTxt = inputTF.getText().trim(); // 获取输入的文本内容并去除文本两端的空格
			contentTA.setText(inputTxt); // 设置内容显示框
			inputTF.setText(""); // 清空文本输入框
			try {
				DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
				dataOutputStream.writeUTF(inputTxt);
				dataOutputStream.flush();
				dataOutputStream.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
