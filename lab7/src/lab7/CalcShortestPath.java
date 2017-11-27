package lab7;
import java.util.Scanner;
import java.io.*;

public class CalcShortestPath {

  public static final int INFINITE = 2147483647;
  public static final int NUMCON = 10000;
  public String reseverPath(TestListG g ,  MyList l , int start,int end , String father){
    StringBuffer str = new StringBuffer("");
    StringBuffer f = new StringBuffer(father +" "+ g.adjl[start].word );
    int p  = l.headList[start].perVer;
    if(l.headList[start].shortestpath == INFINITE){return " ";}//娌℃湁鏈�鐭矾寰�
    if(p == end){
      f.append(" "+g.adjl[p].word+"|");
      return f.toString();
    }
    str.append(reseverPath(g,l,p,end,f.toString()));
    MyList.MyNode e = l.headList[start].fristNode;
    while(e!=null){
      p = e.perVer;
      str.append(reseverPath(g,l,p,end,f.toString()));
      e = e.nextNode;
    }
    return str.toString();
  }

  public String calcShortestPath(TestListG g,String word1,String word2){
    if (g == null || g.getPos(word1) == -1 || g.getPos(word2) == -1){return "";}
    String t = calcShortestPath(g,word1);
    String[] l = t.split("[a-z]*'s:\n");
    int p2 = g.getPos(word2);
    String[] path = l[p2+1].split("\n");

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
            // break;

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
    File adjG = new File("adjGraphcalc."+type);
   gv.writeGraphToFile(gv.getGraph( gv.getDotSource(),type),adjG);

    return l[p2+1];
  }


  public String calcShortestPath(TestListG g,String word1){
    if (g == null ||  g.getPos(word1) == -1)return "";
    int p = g.getPos(word1);
    MyList l  = new MyList(g.versum);
    EdgeNode temp = g.adjl[p].firstedge;
    StringBuffer sb = new StringBuffer("");

    if(temp == null)return "";//娌℃湁鍑鸿矾鏃�
    //l鐨勫垵濮嬪寲
    for(int i = 0; i<g.versum ; i++){
      l.setPathPerVer(p,i,INFINITE);
    }
    while(temp != null){
      l.setPathPerVer(p,temp.verpos,temp.weight);
      temp = temp.nextNode;
     }
    l.headList[p].dirty = true;

    for(int i = 0; i<g.versum -1 ; i++){
      int a = l.getMinCostPos();
      if(a==-1)break;
      System.out.print("a = "+a+" ");
      System.out.print(g.adjl[a].word+" ");
      int s = l.headList[a].shortestpath;
      System.out.println("s = "+s);
      l.headList[a].dirty = true;
      temp = g.adjl[a].firstedge;
      while(temp != null){
    	if(s+temp.weight < l.headList[temp.verpos].shortestpath){
          l.headList[temp.verpos].shortestpath = s+temp.weight;
          l.headList[temp.verpos].perVer = a;
          l.headList[temp.verpos].fristNode = null;
        }
        else if(s+temp.weight == l.headList[temp.verpos].shortestpath){
          l.setPathPerVer(a,temp.verpos);
        }
        temp = temp.nextNode;
      }
    }
    for(int i = 0;i<g.versum;i++){
    	if(l.headList[i].shortestpath == INFINITE)sb.append("|");
    	else  sb.append(reseverPath(g,l,i,p,""));
      sb.append(";");

    }

    //瀛楃涓插鐞�
    StringBuffer result = new StringBuffer("");
    String[] res = sb.toString().split(";");
    for(int i=0; i<res.length ;i++){ //涓嶅悓缁堢偣
      result.append(g.adjl[i].word +"'s:\n");

      StringBuffer tt = new StringBuffer("");
      String[] tm = res[i].split("\\|");//璺緞鍊掑彊鏁扮粍
      for(int j=0;j<tm.length;j++){//鍚屽熬宸翠笉鍚屾渶鐭矾寰�
        String[] tm2 = tm[j].split(" ");
        StringBuffer ttt = new StringBuffer("");
        for(int k = tm2.length -1;k>1;k--){
          ttt.append(tm2[k]+" -> ");
        }

        if(tm2.length>=2)ttt.append(tm2[1]);
        tm[j] = ttt.toString();
        tt.append(tm[j]+"\n");
      }
      res[i] = tt.toString();
      result.append(res[i]);

    }





   return result.toString();

  }

  //图片生成
  public static void printPicture(String result,TestListG g){
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


}
