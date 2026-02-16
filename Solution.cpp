
#include <vector>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {

public:
    int prefixConnected(vector<string>& words, int prefixLength) {
        int numberOfPrefixConnectedGroups = 0;
        unordered_map<string, int> prefixToFrequency;

        for (const auto& word : words) {
            if (word.length() < prefixLength) {
                continue;
            }

            string prefix = word.substr(0, prefixLength);
            ++prefixToFrequency[prefix];

            if (prefixToFrequency[prefix] == 2) {
                ++numberOfPrefixConnectedGroups;
            }
        }

        return numberOfPrefixConnectedGroups;
    }
};
