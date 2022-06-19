import { assert } from "chai";


describe("Direction reduction", function () {
  it("basic tests", function () {
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
    } else if (!opposite(prev, cur)) {
      result.push(prev);
      result.push(cur);
    };
  }
  return result;
}


function opposite(direction: string, oppositeDirection: string): boolean {
  switch (direction) {
    case 'WEST': return oppositeDirection === 'EAST';
    case 'EAST': return oppositeDirection === 'WEST';
    case 'NORTH': return oppositeDirection === 'SOUTH';
    case 'SOUTH': return oppositeDirection === 'NORTH';
    default: return false;
  }
}
