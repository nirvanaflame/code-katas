import { assert } from 'chai';

describe("Consecutive strings", () => {
  it("Basic tests longestConsequence", () => {
    assert.strictEqual(
      longestConsequence(
        ["zone", "abigail", "theta", "form", "libe", "zas"],
        2
      ),
      "abigailtheta"
    );
    assert.strictEqual(
      longestConsequence(
        [
          "ejjjjmmtthh",
          "zxxuueeg",
          "aanlljrrrxx",
          "dqqqaaabbb",
          "oocccffuucccjjjkkkjyyyeehh",
        ],
        1
      ),
      "oocccffuucccjjjkkkjyyyeehh"
    );
    assert.strictEqual(
      longestConsequence(["it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"], 3),
      "ixoyx3452zzzzzzzzzzzz"
    );
  });
});

function longestConsequence(a: string[], k: number): string {
  const n = a.length;
  if (n < 2 || n < k || k <= 0) return "";

  let step = 0;
  let max = 0;
  let index = 0;
  for (let i = k; i <= a.length; i++) {
    let localMax = 0;
    for (let j = step; j < i; j++) {
      localMax += a[j].length;
    }
    if (max < localMax) {
      max = localMax;
      index = step;
    }
    step++;
  }

  return a.slice(index, index + k).join("");
}

// console.log(longestConsequence(["ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"], 1));
