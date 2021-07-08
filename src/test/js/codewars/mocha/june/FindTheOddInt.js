const { expect } = require("chai");

describe("Find the number which appears odd times in array", () => {

  describe("My solution", () => {

    it("should return 5", () => {
      expect(findOdd([20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5])).to.equal(5)
    })

    it("should return -1", () => {
      expect(findOdd([1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5])).to.equal(-1)
    })

    it("should return 5", () => {
      expect(findOdd([20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5])).to.equal(5)
    })

    it("should return -5", () => {
      expect(findOdd([1, 1, 2, -2, 5, 2, 4, 4, -5, -2, 5])).to.equal(-5)
    })

    it("should return number if it is only one", () => {
      expect(findOdd([10])).to.equal(10)
    })

    it("should return 10", () => {
      expect(findOdd([1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1])).to.equal(10)
    })

    it("should return 1", () => {
      expect(findOdd([5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10])).to.equal(1)
    })
  })

  describe("Codewars best soulution", () => {

    it("should return 10", () => {
      expect(findOddBestKataSolution([1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1])).to.equal(10)
    })

    it("should return 1", () => {
      expect(findOddBestKataSolution([5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10])).to.equal(1)
    })
  })

})


/**
 * Given an array of integers, find the one that appears an odd number of times.
 * There will always be only one integer that appears an odd number of times.
 *
 * @param {*} arr
 * @returns number which appears odd time in array
 */
function findOdd(arr) {
  const groupByNumber = arr.reverse().reduce((map, it) => map.set(it, (map.get(it) || 0) + 1), new Map())
  // console.log(groupByNumber)

  var odd = 0
  groupByNumber.forEach((value, key) => {
    // console.log(`[ ${key}, ${value}  ]`)
    if (value % 2 !== 0) {
      odd = key
    }
  });

  return odd
}

/**
 * Function takes first value from array
 * and use XOR operator to compare with the rest
 *
 * @param {Array} xs
 * @returns number which appears odd times
 */
const findOddBestKataSolution = (xs) => xs.reduce((a, b) => a ^ b);
