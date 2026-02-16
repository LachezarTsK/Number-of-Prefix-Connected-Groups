
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int prefixConnected(String[] words, int prefixLength) {

        int numberOfPrefixConnectedGroups = 0;
        Map<String, Integer> prefixToFrequency = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            if (words[i].length() < prefixLength) {
                continue;
            }

            String prefix = words[i].substring(0, prefixLength);
            int updatedFrequency = prefixToFrequency.getOrDefault(prefix, 0) + 1;
            prefixToFrequency.put(prefix, updatedFrequency);

            if (updatedFrequency == 2) {
                ++numberOfPrefixConnectedGroups;
            }
        }

        return numberOfPrefixConnectedGroups;
    }
}
