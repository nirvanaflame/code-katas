const {
  assert
} = require("chai");
const range = (start, stop, step) => Array.from({
  length: (stop - 1 - start) / step + 1
}, (_, i) => start + (i * step))


/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * 
 * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
 * 
 * Note: If the number is a multiple of both 3 and 5, only count it once.
 * Also, if a number is negative, return 0(for languages that do have them)
 */
describe("Sum numbers which module 3 or 5", () => {

  describe("My soulution", () => {

    it("given 16 should sum 3, 5, 6, 9, 10, 12, 15 with result 60", () => {
      assert.strictEqual(sumModuleThreeOrFive(16), 60)
    })

    it("given 8 should sum 3, 5, 6 with result 14", () => {
      assert.strictEqual(sumModuleThreeOrFive(8), 14)
    })

    it("given 22 and 23 should have the same result", () => {
      assert.strictEqual(sumModuleThreeOrFive(22), 119)
      assert.strictEqual(sumModuleThreeOrFive(23), 119)
    })
  })

  describe("Codewars soulution", () => {

    it("given best Codewars colution", () => {
      assert.strictEqual(iterativeSolution(16), 60)
    })

    it("given solution in funcitonal style", () => {
      assert.strictEqual(sumModuleExpression(10), 23)
      assert.strictEqual(sumModuleExpression(20), 78)
    })
  })
})

function sumModuleThreeOrFive(n) {
  if (n < 0) return 0

  const mod3 = range(3, n, 3)
  const mod5 = range(5, n, 5)

  // console.log(mod3)
  // console.log(mod5)
  const arr = [...mod3, ...mod5]

  // console.log(new Set(arr))

  return [...new Set(arr)].reduce((acc, each) => acc + each)
}

const sumModuleExpression = (n) => (n < 4) ? 0 : [...new Set([...range(3, n, 3), ...range(5, n, 5)])].reduce((acc, each) => acc + each)

function iterativeSolution(n) {
  var sum = 0
  for (var i = 0; i < n; i++) {
    if (i % 3 === 0 || i % 5 === 0) {
      sum += i
    }
  }

  return sum
}