const {
  assert
} = require("chai")


/**
 * Write a function that takes in a string of one or more words, and returns the same string, 
 * but with all five or more letter words reversed (like the name of this kata).
 * 
 * Strings passed in will consist of only letters and spaces.
 * Spaces will be included only when more than one word is present.
 */
describe("Spinning words", () => {
  it("should reverse one big word", () => {
    assert.strictEqual(spinWords("Welcome"), "emocleW");
  });

  it("should reverse one word in a sentence", () => {
    assert.strictEqual(spinWords("This is another test"), "This is rehtona test");
  })

  it("should reverse two big words and one left intake", () => {
    assert.strictEqual(spinWords("Hey fellow warriors"), "Hey wollef sroirraw");
  })

  it("should NOT reverse words", () => {
    assert.strictEqual(spinWords("This is a test"), "This is a test");
  })

  it("should reverse two words", () => {
    assert.strictEqual(spinWords("You are almost to the last test"), "You are tsomla to the last test");
  })

  it("should reverse three words", () => {
    assert.strictEqual(spinWords("Just kidding there is still one more"), "Just gniddik ereht is llits one more");
  })
});


function spinWords(text) {
  return text.split(' ').map(function (word) {
    return word.length > 4 ? word.split('').reverse().join('') : word;
  }).join(' ');
}


function spinWordsFunc(text) {
  return text.split(' ').map((word) => (word.length > 4) ? word.split("").reverse().join('') : word).join(" ")
}