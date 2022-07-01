import { assert } from 'chai';

describe("Up and Down:", function () {
  it("basic arrange test", function () {
    assert.strictEqual(arrange(""), ""); // 0
    assert.strictEqual(
      arrange("who hit retaining The That a we taken"),
      "who RETAINING hit THAT a THE we TAKEN"
    ); // 3
    assert.strictEqual(
      arrange("on I came up were so grandmothers"),
      "i CAME on WERE up GRANDMOTHERS so"
    ); // 4
    assert.strictEqual(
      arrange("way the my wall them him"),
      "way THE my WALL him THEM"
    ); // 1
  });
});

export function arrange(s: string): string {
  if (s.length < 1) return "";

  const a = s.split(" ");
  for (let i = 1; i < a.length; i++) {
    const prev = a[i - 1];
    const cur = a[i];

    if (i % 2 === 0 && prev.length < cur.length) {
      swap(i, a);
    } else if (i % 2 === 1 && cur.length < prev.length) {
      swap(i, a);
    }
  }

  return a
    .map((e, i) => (i % 2 === 0 ? e.toLocaleLowerCase() : e.toUpperCase()))
    .join(" ");
}

let temp = "";
const swap = (index: number, a: string[]) => {
  temp = a[index];
  a[index] = a[index - 1];
  a[index - 1] = temp;
};

// console.log(arrange("who hit retaining The That a we taken"));
