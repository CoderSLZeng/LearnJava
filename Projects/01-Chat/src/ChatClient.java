import java.awt.*;

public class ChatClient extends Frame {

	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

	/**
	 * 启动窗口
	 */
	private void launchFrame() {
		setLocation(400, 300); // 窗口坐标位置
		this.setSize(300, 300); // 窗口大小
		setVisible(true); // 显示窗口		
	}

}
