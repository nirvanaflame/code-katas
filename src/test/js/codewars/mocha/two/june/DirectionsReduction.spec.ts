import { assert } from "chai";


describe("Fixed Tests", function () {
  it("dirReduc", function () {
    assert.deepEqual(dirReduc(["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"]), ["WEST"]);
    assert.deepEqual(dirReduc(["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"]), []);
  });
});


export function dirReduc(arr: string[]): string[] {
  const result: string[] = [ arr[0] ];

  for (let i = 1; i < arr.length; i++) {
    let prev = result.pop();
    let cur = arr[i];

    if (typeof prev === 'undefined') { 
      result.push(cur)
    } else if (!oposite(prev, cur)) {
      result.push(prev);
      result.push(cur);
    };
  }
  return result;
}


function oposite(direction: string, oppositeDirection: string): boolean {
  switch (direction) {
    case 'WEST': return oppositeDirection === 'EAST';
    case 'EAST': return oppositeDirection === 'WEST';
    case 'NORTH': return oppositeDirection === 'SOUTH';
    case 'SOUTH': return oppositeDirection === 'NORTH';
    default: return false;
  }
}
