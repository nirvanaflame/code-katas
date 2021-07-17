const {
  assert
} = require("chai")


console.log(adjacentElementsProduct([4, 12, 3, 1, 5]))

/**
 * Given an array of integers, 
 * Find the maximum product obtained from multiplying 2 adjacent numbers in the array.
 * 
 * adjacentElementsProduct([9, 5, 10, 2, 24, -1, -48]); == >
 * return 50
 * 
 * Explanation:
 * Max product obtained from multiplying 5 * 10 = 50
 */
describe('Maximum Product', () => {
  it("Positive numbers", () => {
    assert.equal(adjacentElementsProduct([5, 8]), 40);
    assert.equal(adjacentElementsProduct([1, 2, 3]), 6);
    assert.equal(adjacentElementsProduct([1, 5, 10, 9]), 90);
    assert.equal(adjacentElementsProduct([4, 12, 3, 1, 5]), 48);
    assert.equal(adjacentElementsProduct([5, 1, 2, 3, 1, 4]), 6);
  })

  it("Both positive and negative values", function () {
    assert.equal(adjacentElementsProduct([3, 6, -2, -5, 7, 3]), 21);
    assert.equal(adjacentElementsProduct([9, 5, 10, 2, 24, -1, -48]), 50);
    assert.equal(adjacentElementsProduct([5, 6, -4, 2, 3, 2, -23]), 30);
    assert.equal(adjacentElementsProduct([-23, 4, -5, 99, -27, 329, -2, 7, -921]), -14);
    assert.equal(adjacentElementsProduct([5, 1, 2, 3, 1, 4]), 6);
  })

  it("Contains zeroes", function () {
    assert.equal(adjacentElementsProduct([1, 0, 1, 0, 1000]), 0);
    assert.equal(adjacentElementsProduct([1, 2, 3, 0]), 6);
  })
})


function adjacentElementsProduct(array) {
  const multi = []

  for (i = 1; i < array.length; i++) {
    multi.push(array[i - 1] * array[i])
  }

  return Math.max(...multi)
}