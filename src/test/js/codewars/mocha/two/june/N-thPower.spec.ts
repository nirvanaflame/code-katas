import { assert } from "chai";

describe("N-th Power", () => {

  it("basic test", () => {
    assert.equal(index([1, 2, 3, 4], 2), 9);
    assert.equal(index([1, 3, 10, 100], 3), 1000000);
    assert.equal(index([0, 1], 0), 1);
    assert.equal(index([1, 2], 3), -1);
    assert.equal(index([1, 1, 1, 1, 1, 1, 1, 1, 1, 1], 9), 1);
    assert.equal(index([1, 1, 1, 1, 1, 1, 1, 1, 1, 2], 9), 512);
    assert.equal(index([29, 82, 45, 10], 3), 1000);
    assert.equal(index([6, 31], 3), -1);
    assert.equal(index([75, 68, 35, 61, 9, 36, 89, 0, 30], 10), -1);
  }),

  it("random test from codewars", () => {
    assert.equal(index([1, 9, 2, 1], 4), -1)
  }),

  it("best solution example", () => {
    assert.equal(bestIndex([1, 9, 2, 1], 4), -1)
  })

});

function index(array: number[], n: number): number {
  return array.length <= n ? -1 : Math.pow(array[n], n)
}

export const bestIndex = (array: number[], n: number): number => array[n] ** n || -1;