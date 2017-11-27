package lab7;
import java.util.Scanner;
import java.io.*;


public class ShowDirectedGraph {

  public void showDirectedGraph(TestListG g){
    if (g == null)return;
    GraphViz gv  = new GraphViz();
    gv.addln(gv.start_graph());
    for(int i=0;i<g.versum;i++){
      String str = g.adjl[i].word;
      EdgeNode e = g.adjl[i].firstedge;
      while(e != null){
        gv.addln(str+" -> "+g.adjl[e.verpos].word +"[label = \""+e.weight+"\"];");
        e = e.nextNode;
      }
    }
    gv.addln(gv.end_graph());

    String type = "gif";
    File adjG = new File("adjGraph."+type);
   gv.writeGraphToFile(gv.getGraph( gv.getDotSource(),type),adjG);

  }

}
