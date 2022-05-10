describe('Two to one', () => {

  it('My solution', () => {
    // console.log(longest("aretheyhere", "yestheyarehere"), "aehrsty")
    // console.log(longest("loopingisfunbutdangerous", "lessdangerousthancoding"), "abcdefghilnoprstu")
  })

  it('Best from codewars', () => {
    // console.log(longestOneLiner("inmanylanguages", "theresapairoffunctions"), "acefghilmnoprstuy")
  })
})

function longest(a, b) {
  return (a + b)
    .split('')
    .filter((val, index, arr) => arr.indexOf(val) === index)
    .sort()
    .join('')
}

const longestOneLiner = (s1, s2) => [...new Set(s1 + s2)].sort().join('')