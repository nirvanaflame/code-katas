const {
  assert
} = require("chai");

/**
 * You've just moved into a perfectly straight street with exactly n identical houses on either side of the road. 
 * Naturally, you would like to find out the house number of the people on the other side of the street. 
 * The street looks something like this:
 * 
 * 1|   |6
 * 3|   |4
 * 5|   |2
 * 
 * Evens increase on the right; odds decrease on the left. 
 * House numbers start at 1 and increase without gaps.
 *  When n = 3, 1 is opposite 6, 3 opposite 4, and 5 opposite 2.
 */
describe("Over the road", () => {

  describe("My soulution is the same as the best codewar's 😭", () => {

    it("should return 6 for 1", () => {
      assert.strictEqual(overTheRoad(1, 3), 6);
    })

    it("should return 1 for 6", () => {
      assert.strictEqual(overTheRoad(6, 3), 1);
    })

    it("should return 5 for 2", () => {
      assert.strictEqual(overTheRoad(2, 3), 5);
    })

    it("should return 4 for 3", () => {
      assert.strictEqual(overTheRoad(3, 3), 4);
    })

    it("should return 7 for 11", () => {
      assert.strictEqual(overTheRoad(16, 11), 7);
    })

    it("should return big number for big address", () => {
      assert.strictEqual(overTheRoad(23633656673, 310027696726), 596421736780);
    })
  })
})

function overTheRoad(address, n) {
  // Explain:
  // (2 * 3 + 1) - 3 = 4
  // Need to add +1 for address because first address start from One
  // (2 * 3 + 1) - 1 = 6
  return (2 * n + 1) - address
}