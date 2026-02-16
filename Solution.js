
/**
 * @param {string[]} words
 * @param {number} prefixLength
 * @return {number}
 */
var prefixConnected = function (words, prefixLength) {
    let numberOfPrefixConnectedGroups = 0;
    // CustomizedhMap<string, number>
    const prefixToFrequency = new CustomizedhMap();

    for (let word of words) {
        if (word.length < prefixLength) {
            continue;
        }

        const prefix = word.substring(0, prefixLength);
        const updatedFrequency = prefixToFrequency.getOrDefault(prefix, 0) + 1;
        prefixToFrequency.set(prefix, updatedFrequency);

        if (updatedFrequency === 2) {
            ++numberOfPrefixConnectedGroups;
        }
    }

    return numberOfPrefixConnectedGroups;
};

class CustomizedhMap extends Map {

    getOrDefault(key, defaultValue) {
        if (this.has(key)) {
            return this.get(key);
        }
        return defaultValue;
    }
}
