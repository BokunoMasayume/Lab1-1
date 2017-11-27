package lab7;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.io.*;

import javax.imageio.ImageIO;

//import lab7.CreateDirectedGraph;

public class GUIbuilder extends JFrame implements ActionListener {
  JTextField filename;
  JTextArea textIn;
  JTextArea textOut;
  JTextField pathStart;
  JTextField pathEnd;

  TestListG g;
  String file;
  //start and end word
  String word1;
  String word2;
  String inputText;
  String outputText;

  private TestListG getG(){
    return g;
  }
  private void setG(TestListG gra){
    this.g = gra;
  }

  private String getFile() {
    return file;
  }
  private void setFile(String t) {
    this.file = t;
  }

  private String getWord1() {
    return word1;
  }
  private void setWord1(String t) {
    this.word1 = t;
  }

  private String getWord2() {
    return word2;
  }
  private void setWord2(String t) {
    this.word2 = t;
  }

  private String getInputText() {
    return inputText;
  }
  private void setInputText(String t) {
    this.inputText = t;
  }

  private String getOutputText() {
    return outputText;
  }
  private void setOutputText(String t) {
    this.outputText = t;
  }


  public void createGraph() {
    CreateDirectedGraph cdg = new CreateDirectedGraph();
    String f = this.getFile();
    g = cdg.createDirectedGraph(f);

  }

  public void showGraph() {
    ShowDirectedGraph sdg = new ShowDirectedGraph();
    TestListG ggg = this.getG();
    sdg.showDirectedGraph(ggg);
  }

  public void queryBridgeword() {
	QueryBridgeWords qbw = new QueryBridgeWords();
	this.setOutputText(qbw.queryBridgeWords(this.getG(), this.getWord1(), this.getWord2()));
  }

  public void generateText() {
	QueryBridgeWords qbw = new QueryBridgeWords();
	this.setOutputText(qbw.generateNewText(this.getG(), this.getInputText()));
  }

  public void calcShortestOnlyOrigin() {
	CalcShortestPath csp  =new CalcShortestPath();
	this.setOutputText(csp.calcShortestPath(this.getG(), this.getWord1()));

  }

  public void calcShortest(){
    CalcShortestPath csp  =new CalcShortestPath();
    this.setOutputText(csp.calcShortestPath(this.getG(), this.getWord1(), this.getWord2()));
  }

  public void randomWalk() {
	RandomWalkAssit rw = new RandomWalkAssit();
	rw.randomWalk(this.getG());
  }

  //图片生成
  public void printPicture(String result,TestListG g){
    if(result.compareTo("")==0)return ;
    String[] res = result.split("[a-z]*'s:\n");
    for(int h = 0;h<res.length;h++){
    String[] path = res[h].split("\n");
    GraphViz gv  = new GraphViz();
    gv.addln(gv.start_graph());
    for(int i=0;i<g.versum;i++){
      String str = g.adjl[i].word;
      EdgeNode e = g.adjl[i].firstedge;
      while(e != null){
        boolean flag =  false;
        String emmm = str+" -> "+g.adjl[e.verpos].word;
        for(int j =0;j<path.length;j++){
          if(path[j].indexOf(emmm) != -1)
          {
            flag = true;
            gv.addln(str+" -> "+g.adjl[e.verpos].word +"[color=\""+gv.COLOR[j%30]+"\","+ " label = \""+e.weight+"\"];");


          }
        }
        if(flag ==false)
        {
          gv.addln(str+" -> "+g.adjl[e.verpos].word +"[label = \""+e.weight+"\"];");
        }
        e = e.nextNode;
        }

    }

    gv.addln(gv.end_graph());

    String type = "gif";
    File adjG = new File("adjGraphcalcemmm"+h+"."+type);
   gv.writeGraphToFile(gv.getGraph( gv.getDotSource(),type),adjG);
}

  }


  public void GuiApp(){
    g=null;
    JFrame jf = new JFrame("有向图");
    Container con = jf.getContentPane();
    JButton createDG = new JButton("创建有向图");
    JButton showDG = new JButton("显示有向图");
    JButton queryBW = new JButton("查询桥接词");
    JButton generateNT = new JButton("生成新文本");
    JButton calcSP = new JButton( "计算最短路径 ");
    JButton walkBt=new JButton(" 随机游走  ");
    con.setLayout(new FlowLayout(2,10,10));

    filename = new JTextField("输入文件名",30);
    pathEnd = new JTextField("path end",30);
    pathStart = new JTextField("path start",30);
    textOut = new JTextArea(10,30);
    textIn = new JTextArea(10,30);


    JScrollPane StextOut = new JScrollPane(textOut);



    textOut.setText("out");
    textIn.setText("in");

    con.add(filename);
    con.add(pathEnd);
    con.add(pathStart);
    con.add(textIn);
    con.add(StextOut);

    createDG.addActionListener(this);
    con.add(createDG);

    showDG.addActionListener(this);
    con.add(showDG);

    queryBW.addActionListener(this);
    con.add(queryBW);

    generateNT.addActionListener(this);
    con.add(generateNT);

    calcSP.addActionListener(this);
    con.add(calcSP);

    walkBt.addActionListener(this);
    con.add(walkBt);

    jf.setVisible(true);
    jf.setSize(365,600);
    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }


  public void actionPerformed(ActionEvent e){
    String act = e.getActionCommand();
    if(act == "创建有向图"){
      this.setFile(filename.getText());
      this.createGraph();
    }
   // C:/Users/10953/Desktop/a/test001.txt
    //E:/workspace/tttest/
    else if(act == "显示有向图"){
      this.showGraph();
      new PictureDialog(this,"adjGraph.gif").setVisible(true);
    }
    else if(act == "查询桥接词"){
      this.setWord1(pathStart.getText().toLowerCase());
      this.setWord2(pathEnd.getText().toLowerCase());
      this.queryBridgeword();
      textOut.setText(this.getOutputText());
    }
    else if(act == "生成新文本"){
      this.setInputText(textIn.getText());
      this.generateText();
      textOut.setText(this.getOutputText());
    }
    else if(act == " 随机游走  ")
    {
    	this.randomWalk();
    }
    else{ //璁＄畻鏈�鐭矾寰�
      String t = pathEnd.getText();
      this.setWord1(pathStart.getText().toLowerCase());
      this.setWord2(t.toLowerCase());
      if(t==null || t.compareTo("")==0){
    	  System.out.println("only");
    	this.calcShortestOnlyOrigin();
        String sss = this.getOutputText();
        textOut.setText( (sss.compareTo("")==0)?"NO PATH!":sss );
        if(sss.compareTo("")!=0){
            printPicture(sss,g);
          }
        
      }
      else{
    	  System.out.println("no only");
    	this.calcShortest();
        String emmm = this.getOutputText();
        textOut.setText( emmm.compareTo("")==0?"NO PATH!":emmm );
        if((emmm.compareTo("")!=0)){
            System.out.println("should print pic");
            new PictureDialog(this,"adjGraphcalc.gif").setVisible(true);
          }

      }

    }
  }



   public static void main(String[] args){
     new GUIbuilder().GuiApp();
   }

}



class PictureDialog extends JDialog{
  public PictureDialog(GUIbuilder f, String picname){
    super(f,picname,true);
    Container con = getContentPane();
    JLabel jl = new JLabel();
   // URL url = PictureDialog.class.getResource(picname);
    Icon icon = new ImageIcon(picname);
    jl.setIcon(icon);
    con.add(new JScrollPane( jl));

    try{
    File ppp = new File(picname);
    BufferedImage sss = ImageIO.read(ppp);

    int w = sss.getWidth();
    int h = sss.getHeight();
    setBounds(120,120,w,400);
  }catch(IOException e){e.printStackTrace();}

  }


}
