
function prefixConnected(words: string[], prefixLength: number): number {
    let numberOfPrefixConnectedGroups = 0;
    const prefixToFrequency = new CustomizedhMap<string, number>();

    for (let i = 0; i < words.length; ++i) {
        if (words[i].length < prefixLength) {
            continue;
        }

        const prefix = words[i].substring(0, prefixLength);
        const updatedFrequency = prefixToFrequency.getOrDefault(prefix, 0) + 1;
        prefixToFrequency.set(prefix, updatedFrequency);

        if (updatedFrequency === 2) {
            ++numberOfPrefixConnectedGroups;
        }
    }

    return numberOfPrefixConnectedGroups;
};

class CustomizedhMap<Key, Value> extends Map {

    getOrDefault(key: Key, defaultValue: Value): Value {
        if (this.has(key)) {
            return this.get(key);
        }
        return defaultValue;
    }
}
