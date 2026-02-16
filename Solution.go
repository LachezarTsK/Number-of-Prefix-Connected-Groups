
package main

func prefixConnected(words []string, prefixLength int) int {
    numberOfPrefixConnectedGroups := 0
    prefixToFrequency := map[string]int{}

    for _, word := range words {
        if len(word) < prefixLength {
            continue
        }

        prefix := word[:prefixLength]
        updatedFrequency := getOrDefault(prefixToFrequency, prefix, 0) + 1
        prefixToFrequency[prefix] = updatedFrequency

        if updatedFrequency == 2 {
            numberOfPrefixConnectedGroups++
        }
    }

    return numberOfPrefixConnectedGroups
}

func getOrDefault[Key comparable, Value any](mapToCheck map[Key]Value, key Key, defaultValue Value) Value {
    if value, has := mapToCheck[key]; has {
        return value
    }
    return defaultValue
}
