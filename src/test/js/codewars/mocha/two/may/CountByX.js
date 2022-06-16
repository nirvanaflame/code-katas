const chai = require("chai");
const assert = chai.assert;
chai.config.truncateThreshold = 0;

describe("Count by X", function () {
  it("From One to Ten", () => {
    assert.deepEqual(countBy(1, 10), [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], "Array does not match")
  });

  it("From Two to Ten in a Five steps", () => {
    assert.deepEqual(countBy(2, 5), [2, 4, 6, 8, 10], "Array does not match")
  })
});


function countBy(x, n) {
  const a = []
  for (let i = x; i <= x * n; i = i + x) a.push(i)
  return a
}