package lab7;
import java.util.Random;

public class QueryBridgeWords {

  public static String queryBridgeWords(TestListG g,String word1,String word2){
    if (g == null)return "";
    int pos1 = g.getPos(word1.toLowerCase());
    int pos2 = g.getPos(word2.toLowerCase());
    StringBuffer bridge = new StringBuffer("");
    if(pos1 == -1 || pos2 == -1)return "No word1 or word2 in the graph!";
    else
    {
      EdgeNode e1 = g.adjl[pos1].firstedge;
      while(e1 != null){
        EdgeNode e2 = g.adjl[e1.verpos].firstedge;
        while(e2 != null){
          if(e2.verpos == pos2)
          {
            bridge.append(g.adjl[e1.verpos].word + " ");
          }
          e2 = e2.nextNode;
        }
        e1 = e1.nextNode;
      }
      if(bridge.length() == 0){
        return "No bridge words from word1 to word2!";
      }
      else{
        return "The bridge words from word1 to word2 are:"+bridge;
      }
    }
  }



  public static String generateNewText(TestListG g,String inputText){
    if (g == null)return "";
    StringBuffer result = new StringBuffer("");
    String[] input = inputText.split(" ");
    String sss = "The bridge words from word1 to word2 are:";
    if(input.length>=1){result.append(input[0]+" ");}
    for(int i = 1;i < input.length;i++){
      String sour_str = queryBridgeWords(g,input[i-1],input[i]);
      if(sour_str.startsWith(sss))
      {
        String str = sour_str.substring(sss.length());
        String[] bridges = str.split(" ");
        Random r = new Random();
        int j = r.nextInt(bridges.length );
        result.append(bridges[j] + " " + input[i] + " ");
      }
      else{
          result.append(input[i]+" ");
        }
    }

    return result+"";
  }

}
