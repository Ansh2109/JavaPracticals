import java.util.*;

public class Leaderboard{
    public static void main(String[] args){
        Map<String,Integer> scores=new HashMap<>();

        scores.put("Tirth",90);
        scores.put("Om",85);
        scores.put("Ansh",95);
        scores.put("Jugal",90);
        scores.put("Ryan",80);

        int n=3;

        List<Map.Entry<String,Integer>> list=new ArrayList<>(scores.entrySet());

        list.sort((a,b)->{
            int result=b.getValue().compareTo(a.getValue());
            if(result==0){
                return a.getKey().compareTo(b.getKey());
            }
            return result;
        });

        System.out.println("Top "+n+" Players:");

        for(int i=0;i<Math.min(n,list.size());i++){
            System.out.println(list.get(i).getKey()+" : "+list.get(i).getValue());
        }
    }
}