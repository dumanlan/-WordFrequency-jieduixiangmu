import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChuLi extends JPanel{
	public ChuLi()
	{
		this.setLayout(new GridLayout(4,1));
		JLabel FN=new JLabel("文件名:"+MainWindows.Filename);
		this.add(FN);
		JLabel J=new JLabel("文件共有"+MainWindows.zifu+"字符");
		this.add(J);
		JLabel h=new JLabel("文件共有"+MainWindows.hang+"行");
		this.add(h);
		JLabel c=new JLabel("处理文件共花费"+MainWindows.time+"ms");
		this.add(c);
	}
	
}
