import java.awt.*;
import java.awt.event.*;

public class ChatClient extends Frame {
	
	TextArea taContent = new TextArea(); // 多行文本输入框
	TextField tfTxt = new TextField(); // 单行文本输入框

	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

	/**
	 * 启动窗口
	 */
	private void launchFrame() {
		setLocation(400, 300); // 窗口坐标位置
		this.setSize(300, 300); // 窗口大小
		add(tfTxt, BorderLayout.SOUTH);  // 上北
		add(taContent, BorderLayout.NORTH); // 下南
		pack();
		this.addWindowListener(new WindowAdapter() { // 添加窗口监听事件

			@Override
			public void windowClosing(WindowEvent e) { // 监听窗口关闭
				System.exit(0);
			}
			
		});
		setVisible(true); // 显示窗口		
	}

}
