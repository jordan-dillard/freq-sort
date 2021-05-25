import java.util.*;
import java.util.stream.Collectors;

public class FreqSorter {

    // INSTANCE FIELDS
    private Set<Map.Entry<String, Integer>> uniqueFreqs; // the set of mappings from unique words to their integer-valued frequencies

    // CONSTRUCTORS

    /**
     * Constructs a FreqSorter with the initial, unaltered list of repeatable words.
     *
     * @param words an ArrayList<String> object representing a list of repeatable words
     */
    public FreqSorter(ArrayList<String> words){
        Map<String, Integer> freqMap = getFreqMap(words);
        this.uniqueFreqs = freqMap.entrySet();
    }

    // FUNCTIONS

    /**
     * Given a list of (repeatable) words, returns a Hashmap that goes from String keys for each unique word to Integers representing their frequency in the list.
     *
     * @param words an ArrayList<String> object representing the list of words to extract a frequency Hashmap from
     * @return
     */
    private Map<String, Integer> getFreqMap(ArrayList<String> words){
        Map<String, Integer> freqMap = new HashMap<>();

        for(String s : words){
            if(freqMap.get(s) == null) freqMap.put(s, 1);
            else if(freqMap.get(s) != null) freqMap.put(s, freqMap.get(s)+1);
        }

        return freqMap;
    }

    /**
     * Prints each entry in the set of word frequencies on separate lines, in descending order of frequencies
     */
    public void printByDescendingOrder(){
        this.uniqueFreqs.stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(System.out::println);
    }

    /**
     * Prints each entry in the set of word frequencies on separate lines, in ascending order of frequencies
     */
    public void printByAscendingOrder(){
        this.uniqueFreqs.stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }
}
