import { assert, config } from 'chai';

config.truncateThreshold = 0;

function testing(arr: string[], expected: string[][]) {
  assert.deepEqual(partList(arr), expected);
}

describe("Part of List", function () {
  it("Basic tests", function () {
    testing(
      ["I", "wish", "I", "hadn't", "come"],
      [
        ["I", "wish I hadn't come"],
        ["I wish", "I hadn't come"],
        ["I wish I", "hadn't come"],
        ["I wish I hadn't", "come"],
      ]
    );
    testing(
      ["cdIw", "tzIy", "xDu", "rThG"],
      [
        ["cdIw", "tzIy xDu rThG"],
        ["cdIw tzIy", "xDu rThG"],
        ["cdIw tzIy xDu", "rThG"],
      ]
    );
    testing(
      ["vJQ", "anj", "mQDq", "sOZ"],
      [
        ["vJQ", "anj mQDq sOZ"],
        ["vJQ anj", "mQDq sOZ"],
        ["vJQ anj mQDq", "sOZ"],
      ]
    );
    testing(
      ["mkC", "WoiP", "pCHh", "mkv"],
      [
        ["mkC", "WoiP pCHh mkv"],
        ["mkC WoiP", "pCHh mkv"],
        ["mkC WoiP pCHh", "mkv"],
      ]
    );
    testing(
      ["vHW", "bPq", "pme", "jJr", "HGHV"],
      [
        ["vHW", "bPq pme jJr HGHV"],
        ["vHW bPq", "pme jJr HGHV"],
        ["vHW bPq pme", "jJr HGHV"],
        ["vHW bPq pme jJr", "HGHV"],
      ]
    );
    testing(
      ["YZd", "ptUD", "IXr"],
      [
        ["YZd", "ptUD IXr"],
        ["YZd ptUD", "IXr"],
      ]
    );
  });
});

const flatten = (arr: string[]): string =>
  arr.reduce((acc, it) => acc + " " + it);

export function partList(arr: string[]): string[][] {
  const res: string[][] = [];
  for (let i = 1; i < arr.length; i++) {
    res.push([flatten(arr.slice(0, i)), flatten(arr.slice(i))]);
  }

  return res;
}

const partListBest = (arr: string[]): string[][] =>
  arr
    .map((_, index) => [
      arr.slice(0, index).join(" "),
      arr.slice(index).join(" "),
    ])
    .slice(1);
