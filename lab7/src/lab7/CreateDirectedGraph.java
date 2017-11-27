package lab7;

import java.util.Scanner;
import java.io.*;

public class CreateDirectedGraph {
  public static final int INFINITE = 2147483647;
  public static final int NUMCON = 10000; 
  public  TestListG createDirectedGraph(String filename){
    TestListG g = new TestListG();
    try{

    InputStream is = new FileInputStream(filename);
    int size = is.available();
    String[] wordList  = new String[NUMCON];//直接用数字了
    String str,per_str=null;
    int pos=0,a,per_pos,now_pos;
    char[] t = new char[30];
    for(int i=0; i< size; i++){
      a  = is.read() ;
      if((a<=90 && a>=65) || (a<=122 && a>=97))
      {
        if(a<=90 && a>=65){a += 32;}
        t[pos++]  = (char)a;
      }
      else if(pos!=0)
      {
        str = new String(t,0,pos);
        pos = 0;
        per_pos = g.getPos(per_str);
        now_pos = g.getPos(str);
        if(now_pos == -1){
          g.addVer(str);
        }
        if(per_pos!=-1){

        g.addEdge(per_pos,now_pos==-1?g.versum-1:now_pos);
      }
      per_str = str;
      }


    }
      is.close();

    }catch(IOException e){
      System.out.print("Exception");
    }
    return g;
  }

}
