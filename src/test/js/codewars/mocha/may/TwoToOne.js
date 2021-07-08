function longest(a, b) {
  return (a + b)
    .split('')
    .filter((val, index, arr) => arr.indexOf(val) === index)
    .sort()
    .join('')
}

console.log(longest("aretheyhere", "yestheyarehere"), "aehrsty")
console.log(longest("loopingisfunbutdangerous", "lessdangerousthancoding"), "abcdefghilnoprstu")


const longestOneLiner = (s1, s2) => [...new Set(s1 + s2)].sort().join('')
console.log(longestOneLiner("inmanylanguages", "theresapairoffunctions"), "acefghilmnoprstuy")
