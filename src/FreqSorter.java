import java.util.*;

public class FreqSorter {

    private Set<Map.Entry<String, Integer>> uniqueFreqs;

    public FreqSorter(ArrayList<String> words){
        Map<String, Integer> freqMap = getFreqMap(words);
        this.uniqueFreqs = freqMap.entrySet();
    }

    private Map<String, Integer> getFreqMap(ArrayList<String> words){
        Map<String, Integer> freqMap = new HashMap<>();

        for(String s : words){
            if(freqMap.get(s) == null) freqMap.put(s, 1);
            else if(freqMap.get(s) != null) freqMap.put(s, freqMap.get(s)+1);
        }

        return freqMap;
    }

    public void sortFreqSetByDescendingOrder(){
        this.uniqueFreqs.stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
    }

    public void sortFreqSetByAscendingOrder(){
        this.uniqueFreqs.stream().sorted(Map.Entry.comparingByValue());
    }

    public void printFreqs(){
        for(Map.Entry<String, Integer> set : uniqueFreqs){
            String word = set.getKey();
            Integer freq = set.getValue();
            System.out.println(word + ": " + freq);
        }
    }
}
