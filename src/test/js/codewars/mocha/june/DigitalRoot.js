const { expect } = require("chai");

describe("Sum digits while number is not simple", () => {

  it("should sum number with two digits", () => {
    expect(digitalRoot(16)).to.be.eq(7)
  })

  it("should sum number with tree digits", () => {
    expect(digitalRoot(456)).to.be.eq(6)
  })

  it("should use Math to sum number with one digit", () => {
    expect(digitalRootMath(5)).to.be.eq(5)
  })

  it("should use Math formula to sum number with many digits", () => {
    expect(digitalRootMath(75869)).to.equal(8)
  })
})


/*
Digital root is the recursive sum of all the digits in a number.

Given n, take the sum of the digits of n.
If that value has more than one digit, continue reducing in this way until a single-digit number is produced.
The input will be a non-negative integer.
*/

function digitalRoot(n) {
  return (n < 0 || n < 10) ? n : digitalRoot(
    n.toString().split('')
      .map(it => parseInt(it))
      .reduce((acc, each) => acc + each)
  )
}

// 17 - 1 -> 16 % 9 -> 7 + 1 = 8  <-> 8 = 1+7 -> 17
function digitalRootMath(n) {
  return (n - 1) % 9 + 1
}