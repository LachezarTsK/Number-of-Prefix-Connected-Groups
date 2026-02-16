
class Solution {

    fun prefixConnected(words: Array<String>, prefixLength: Int): Int {
        var numberOfPrefixConnectedGroups = 0
        val prefixToFrequency = mutableMapOf<String, Int>()

        for (word in words) {
            if (word.length < prefixLength) {
                continue
            }

            val prefix = word.take(prefixLength)
            val updatedFrequency = prefixToFrequency.getOrDefault(prefix, 0) + 1
            prefixToFrequency[prefix] = updatedFrequency

            if (updatedFrequency == 2) {
                ++numberOfPrefixConnectedGroups
            }
        }

        return numberOfPrefixConnectedGroups
    }
}
