describe("Array Diff:", () => {
  it("Basic test", () => {
    expect(arrayDiff([], [4, 5])).to.eql([], "a was [], b was [4,5]");
    expect(arrayDiff([3, 4], [3])).to.eql([4], "a was [3, 4], b was [3]");
    expect(arrayDiff([1, 8, 2], [])).to.eql(
      [1, 8, 2],
      "a was [1, 8, 2], b was []"
    );
    expect(arrayDiff([1, 2, 3], [1, 2])).to.eql(
      [3],
      "a was [1, 2, 3], b was [1, 2]"
    );
  });
});

function arrayDiff(a: number[], b: number[]): number[] {
  a.sort();
  b.sort();

  let j = 0;
  const res = [];
  for (let i = 0; i < b.length; i++) {
    if (j >= a.length) break;

    console.log(`${j} and ${i}`);
    console.log(a[j] < b[i] && a[j] !== b[i]);
    while (a[j] < b[i]) {
      if (a[j] !== b[i]) {
        res.push(a[j++]);
      }
    }
    j++;
    console.log(a[j]);
  }

  for (let i = j; i < a.length; i++) {
    console.log(a[i]);

    res.push(a[i]);
  }

  return res;
}

// console.log(arrayDiff([1, 2, 3], [1, 2]));
