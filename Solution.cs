
using System;
using System.Collections.Generic;

public class Solution
{
    public int PrefixConnected(string[] words, int prefixLength)
    {
        int numberOfPrefixConnectedGroups = 0;
        Dictionary<string, int> prefixToFrequency = [];

        foreach (string word in words)
        {
            if (word.Length < prefixLength)
            {
                continue;
            }

            string prefix = word.Substring(0, prefixLength);
            prefixToFrequency.TryAdd(prefix, 0);
            ++prefixToFrequency[prefix];

            if (prefixToFrequency[prefix] == 2)
            {
                ++numberOfPrefixConnectedGroups;
            }
        }

        return numberOfPrefixConnectedGroups;
    }
}
