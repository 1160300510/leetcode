package Medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class dota2_senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        int radiant=0, dire=0;
        for(int i=0; i<n; i++){
            if(senate.charAt(i) == 'R'){
                radiant++;
            }else{
                dire++;
            }
        }
        boolean[] votes = new boolean[n];
        Arrays.fill(votes, true);
        int j = 0;
        while (radiant!=0 && dire!=0){
            j %= n;
            if(senate.charAt(j)=='R'){
                if(votes[j]){
                    for(int k=j+1; k<j+n; k++){
                        if(senate.charAt(k%n)=='D' && votes[k%n]){
                            votes[k%n] = false;
                            dire--;
                            break;
                        }
                    }
                }
            }else{
                if(votes[j]){
                    for(int k=j+1; k<j+n; k++){
                        if(senate.charAt(k%n)=='R' && votes[k%n]){
                            votes[k%n] = false;
                            radiant--;
                            break;
                        }
                    }
                }
            }
            j++;
        }
        return radiant==0 ? "Dire" : "Radiant";
    }

    public String predictPartyVictory2(String senate){
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(senate.charAt(i) == 'R'){
                radiant.offer(i);
            }else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()){
            int radiantindex = radiant.poll();
            int direindex = dire.poll();
            if(radiantindex < direindex){
                radiant.offer(radiantindex+n);
            }else{
                dire.offer(direindex+n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
