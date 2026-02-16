
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int prefixConnected(String[] words, int prefixLength) {

        int numberOfPrefixConnectedGroups = 0;
        Map<String, Integer> prefixToFrequency = new HashMap<>();

        for (String word : words) {
            if (word.length() < prefixLength) {
                continue;
            }

            String prefix = word.substring(0, prefixLength);
            int updatedFrequency = prefixToFrequency.getOrDefault(prefix, 0) + 1;
            prefixToFrequency.put(prefix, updatedFrequency);

            if (updatedFrequency == 2) {
                ++numberOfPrefixConnectedGroups;
            }
        }

        return numberOfPrefixConnectedGroups;
    }
}
