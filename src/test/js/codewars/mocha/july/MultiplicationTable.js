const {
  expect
} = require('chai')


/**
 * Your task, is to create NxN multiplication table, of size provided in parameter.
 * for example, when given size is 3:
 * 
 * 1 2 3
 * 2 4 6
 * 3 6 9
 * 
 * for given example, the return value should be: [[1,2,3],[2,4,6],[3,6,9]]
 */
describe("Multiplication table", () => {
  it("should return matrix", () => {
    expect(multiplicationTable(3)).is.eql([
      [1, 2, 3],
      [2, 4, 6],
      [3, 6, 9]
    ]);
  });
});

function multiplicationTable(n) {

  const row = []
  for (let i = 1; i <= n; i++) {

    const col = []
    for (let j = 1; j <= n; j++) {
      col.push(i * j)
    }
    row.push(col)
  }

  return row
}