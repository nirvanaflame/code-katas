describe("Binary array to number", () => {

  it('My solution', () => {
    // Add desribtion and testion scenarios
    // console.log(binaryArrayToNumber([1, 0, 0, 1]), 9);
    // console.log(binaryArrayToNumber([0, 0, 1, 0]), 2);
    // console.log(binaryArrayToNumber([1, 1, 1, 1]), 15);
  })
  it('Best from codewars', () => {
    // console.log(binaryArrayToNumberClever([0, 1, 1, 0]), 6);
  })
})


const binaryArrayToNumber = arr => {
  let arr2 = arr.reverse()
  return arr2.reduce((acc, each, index) => acc + each * Math.pow(2, index), 0)
};

const binaryArrayToNumberClever = arr => parseInt(arr.join(''), 2);