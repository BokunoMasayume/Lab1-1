package lab7;

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;

public class RandomWalkAssit {
  public static final int INFINITE = 2147483647;
  public static final int NUMCON = 10000;
  public String randomWalkAssit(TestListG G) {
		String res = new String();
		Random ran = new Random();
		int i = ran.nextInt(G.versum);// 闅忔満娓歌蛋鐨勮捣鐐�
		String[] edgeArr=new String[NUMCON];
		VerNode[] verArr = new VerNode[NUMCON];
		EdgeNode edgeTmp;
		int count = 0;
		res=G.adjl[i].word;//璧风偣
		verArr[count]=G.adjl[i];
		edgeTmp = G.adjl[i].firstedge;

		while (edgeTmp != null)// 鏈夊嚭杈�
		{
			EdgeNode tmp;
			tmp = edgeTmp;
			int outLine = 1;
			// 鍏堢粺璁℃湁鍑犳潯鍑鸿竟 锛岄�変竴鏉�
			while (tmp.nextNode!= null) {
				outLine++;
				tmp=tmp.nextNode;
			}
			int j = ran.nextInt(outLine);
			for (int k = 0; k < j; k++) {
				edgeTmp = edgeTmp.nextNode;// 涓嬩釜鑺傜偣
			}
			String temp=new String();
			temp=G.adjl[i].word+G.adjl[edgeTmp.verpos].word;//new edge
			for (int k = 0; k < count; k++) {
				if (temp.equals(edgeArr[k])) {
					verArr[count++] = G.adjl[edgeTmp.verpos];
					return res + " "+G.adjl[edgeTmp.verpos].word;
				}
			}
			edgeArr[count++] = temp;
			i=edgeTmp.verpos;
			edgeTmp = G.adjl[i].firstedge;

			verArr[count++] = G.adjl[i];
			res = res + " " + G.adjl[i].word;
		}
		//System.out.println(res);
		return res;
	}

	// 闅忔満娓歌蛋 鏈�濂藉浘鏈夐珮浜樉绀�
	public String randomWalk(TestListG G) {

		final TestListG g = G;
		final JLabel lab = new JLabel();
		String re = new String("aa");
		final JFrame jf = new JFrame("闅忔満娓歌蛋");


		JButton startBt = new JButton("寮�濮�");
		JButton stopBt = new JButton("鍋滄");

		startBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lab.setText(randomWalkAssit(g));
				lab.setVisible(true);

			}
		});
		stopBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
			}
		});

		jf.setSize(500, 200);
		jf.setLayout(new BorderLayout());
		jf.add(startBt, BorderLayout.WEST);
		jf.add(stopBt, BorderLayout.EAST);
		jf.add(new JScrollPane(lab), BorderLayout.CENTER);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setVisible(true);

		return re;

	}
}
