const {
  assert
} = require("chai")

class Point {
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }
}


/**
 * This series of katas will introduce you to basics of doing geometry with computers.
 * Point objects have x and y attributes(X and Y in C#) attributes.
 * Write a function calculating distance between Point a and Point b.
 * Tests round answers to 6 decimal places.
 */
describe("Distance between two Points", function () {
  it("test my solution with sample tests", function () {
    assert.strictEqual(distanceBetweenPoints(new Point(3, 3), new Point(3, 3)), 0);
    assert.strictEqual(distanceBetweenPoints(new Point(1, 6), new Point(4, 2)), 5);
    assert.deepEqual(distanceBetweenPoints(new Point(-10.2, 12.5), new Point(0.3, 14.7)).toFixed(6), '10.728001');
  });

  it("test best codewars solution with sample tests", function () {
    assert.strictEqual(bestOfCodewars(new Point(3, 3), new Point(3, 3)), 0);
    assert.strictEqual(bestOfCodewars(new Point(1, 6), new Point(4, 2)), 5);
    assert.deepEqual(bestOfCodewars(new Point(-10.2, 12.5), new Point(0.3, 14.7)).toFixed(6), '10.728001');
  });
});


function distanceBetweenPoints(a, b) {
  const katetX = Math.pow(a.x - b.x, 2)
  const katetY = Math.pow(a.y - b.y, 2)

  return Math.sqrt(katetX + katetY);
}

function bestOfCodewars(a, b) {
  return Math.hypot(a.x - b.x, a.y - b.y)
}