import { assert } from "chai";

function testing(actual, expected) {
  assert.equal(actual, expected);
}

describe("Max length difference", function () {
  it("basic tests", function () {

    var s1 = ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"];
    var s2 = ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"];
    testing(mxdiflg(s1, s2), 13);
    s1 = ["ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"];
    s2 = ["bbbaaayddqbbrrrv"];
    testing(mxdiflg(s1, s2), 10);
    s1 = ["ccct", "tkkeeeyy", "ggiikffsszzoo", "nnngssddu", "rrllccqqqqwuuurdd", "kkbbddaakkk"];
    s2 = ["tttxxxxxxgiiyyy", "ooorcvvj", "yzzzhhhfffaaavvvpp", "jjvvvqqllgaaannn", "tttooo", "qmmzzbhhbb"];
    testing(mxdiflg(s1, s2), 14);
    s1 = [];
    s2 = ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"];
    testing(mxdiflg(s1, s2), -1);
    s2 = [];
    s1 = ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"];
    testing(mxdiflg(s1, s2), -1);
    s1 = [];
    s2 = [];
    testing(mxdiflg(s1, s2), -1);

  });
});


const mxdiflg = (a1: string[], a2: string[]): number => {
  if (!a1.length || !a2.length) return -1

  const n1 = a1.map(s => s.length);
  const n2 = a2.map(s => s.length);

  const mx1 = Math.max(...n1);
  const mn1 = Math.min(...n1);

  const mx2 = Math.max(...n2);
  const mn2 = Math.min(...n2);

  return Math.max(mx1 - mn2, mx2 - mn1);
}

// console.log(mxdiflg(['asd', 'vasda'], ['asdasda']))
