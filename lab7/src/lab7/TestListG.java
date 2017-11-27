package lab7;

import java.util.Random;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;


public class TestListG {

  public static final int INFINITE = 2147483647;
  public static final int NUMCON = 10000;

  public int versum; //椤剁偣瀹為檯鏁�
  public VerNode[] adjl;  //椤剁偣鏁扮粍锛岄偦鎺ヨ〃澶�

  public TestListG(int vmax) //鏋勯�犲嚱鏁�1
  {
       versum = 0;
       adjl = new VerNode[vmax];
  }

  public TestListG() //鏋勯�犲嚱鏁�2
  {
      versum = 0;
      adjl = new VerNode[NUMCON];
  }

  public int getPos(String vname) //鑾峰彇鍗曡瘝鍦ㄩ《鐐规暟缁勭殑涓嬫爣锛屼笉瀛樺湪鐨勫崟璇嶈繑鍥�-1
  {
    for(int i=0;i<versum;i++)
    {
      if(adjl[i].word.compareTo(vname)==0)
      {
        return i;
      }
    }

    return -1;
  }

  public void addEdge(int per_pos,int now_pos) //娣诲姞杈�
  {
      EdgeNode temp = adjl[per_pos].firstedge;
      boolean flag  = false;
      while(temp!=null )
      {
        if(temp.verpos == now_pos){
          temp.weight++;
          flag = true;
          break;
        }
        if(temp.nextNode == null){
                break;
        }
        temp = temp.nextNode;
      }

      if(temp == null){
        adjl[per_pos].firstedge = new EdgeNode();
        adjl[per_pos].firstedge.weight = 1;
        adjl[per_pos].firstedge.nextNode = null;
        adjl[per_pos].firstedge.verpos = now_pos;
      }
      else if(temp.nextNode == null && flag == false){
        temp.nextNode = new EdgeNode();
        temp.nextNode.weight = 1;
        temp.nextNode.verpos = now_pos;
        temp.nextNode.nextNode = null;
      }
  }


  public void addVer(String str)//娣诲姞椤剁偣
  {
      adjl[versum] = new VerNode();
      adjl[versum].word = str;
      adjl[versum].firstedge = null;
      versum ++;
  }



}
