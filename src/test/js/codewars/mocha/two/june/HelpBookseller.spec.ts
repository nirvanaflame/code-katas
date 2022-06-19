import { assert } from "chai";

function testing(listOfArt, listOfCat, expected) {
  assert.equal(G964.stockList(listOfArt, listOfCat), expected);
}

describe("Help bookseller", function () {
  it("basic test", function () {
    var b, c, res;
    b = ["BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 0600"];
    c = ["A", "B", "C", "D"];
    res = "(A : 0) - (B : 1290) - (C : 515) - (D : 600)";
    testing(b, c, res);
  });

  it("empty input", function () {
    var b, c, res;
    b = [];
    c = ['B', 'R', 'D', 'X'];
    res = "(B : 0) - (R : 0) - (D : 0) - (X : 0)";
    testing(b, c, res);
  });
});


export class G964 {

  public static stockList = (listOfArt, listOfCat) => {
    
    const map: Map<string, number> = new Map();
    listOfArt.forEach(art => {
      const [cat, amount] = art.split(" ");
      const fChar = cat.charAt(0)

      mapMerge(map, fChar, Number(amount));
    })

    let out = ""
    listOfCat.forEach(cat => {
      out += `(${cat} : ${getValOrZero(map, cat)}) - `
    })

    return out.slice(0, out.length - 3);
  }
}

function getValOrZero(map: Map<string, number>, cat: string): number {
  return typeof map[cat] === 'undefined' ? 0 : map[cat];
}

function mapMerge(map: Map<string, number>, cat: string, amount: number): void {
  if (map[cat] > 0) {
    const prev: number = map[cat];
    map[cat] = +prev + amount;
  } else {
    map[cat] = amount;
  }
}