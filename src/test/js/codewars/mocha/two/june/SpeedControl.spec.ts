import { assert } from "chai";


function testing(actual, expected) {
  var r = Math.abs(actual - expected);
  var inrange = r <= 1;
  assert.equal(inrange, true, "abs(actual - expected) must be <= 1 but was  " + r);
}

describe("Speed control gps", function () {
  it("basic tests", function () {
    var x = [0.0, 0.23, 0.46, 0.69, 0.92, 1.15, 1.38, 1.61];
    var s = 20;
    var u = 41;
    testing(gps(s, x), u);
    x = [0.0, 0.11, 0.22, 0.33, 0.44, 0.65, 1.08, 1.26, 1.68, 1.89, 2.1, 2.31, 2.52, 3.25];
    s = 12;
    u = 219;
    testing(gps(s, x), u);
    x = [0.0, 0.18, 0.36, 0.54, 0.72, 1.05, 1.26, 1.47, 1.92, 2.16, 2.4, 2.64, 2.88, 3.12, 3.36, 3.6, 3.84];
    s = 20;
    u = 80;
    testing(gps(s, x), u);
  });
});


const gps = (s: number, x: number[]): number => {
  let maxSpeed = 0;
  for (let i = 1; i < x.length; i++) {
    maxSpeed = Math.max(
      Math.floor(((x[i] - x[i - 1]) * 3600) / s),
      maxSpeed
    )
  }
  return maxSpeed;
}

const x = [0.0, 0.18, 0.36, 0.54, 0.72, 1.05, 1.26, 1.47, 1.92, 2.16, 2.4, 2.64, 2.88, 3.12, 3.36, 3.6, 3.84];
const s = 20;
// console.log(gps(s, x))

