const { assert } = require("chai");

describe("Who likes it", () => {

  it("No one likes it", () => {
    assert.strictEqual(likes([]), 'no one likes this');
  })

  it("Peter likes this", () => {
    assert.strictEqual(likes(['Peter']), 'Peter likes this');
  })

  it("Jacob and Alex like this", () => {
    assert.strictEqual(likes(['Jacob', 'Alex']), 'Jacob and Alex like this');
  })

  it("Max, John and Mark like this", () => {
    assert.strictEqual(likes(['Max', 'John', 'Mark']), 'Max, John and Mark like this');
  })

  it("Alex, Jacob and 2 others like this", () => {
    assert.strictEqual(likes(['Alex', 'Jacob', 'Mark', 'Max']), 'Alex, Jacob and 2 others like this');
  })
})

/**
 * 
 * You probably know the "like" system from Facebook and other pages. 
 * People can "like" blog posts, pictures or other items.
 * We want to create the text that should be displayed next to such an item.
 * Implement a function likes :: [String] -> String, which must take in input array, 
 * containing the names of people who like an item. 
 * It must return the display text as shown in the examples:
 * 
 * 
 * @param {String} arr with Names
 * @returns text with names
 */
function likes(arr) {
  switch (arr.length) {
    case 0:
      return 'no one likes this';
    case 1:
      return `${arr[0]} likes this`;
    case 2:
      return `${arr[0]} and ${arr[1]} like this`;
    case 3:
      return `${arr[0]}, ${arr[1]} and ${arr[2]} like this`;
    default:
      return `${arr[0]}, ${arr[1]} and ${arr.length - 2} others like this`;
  }
}
