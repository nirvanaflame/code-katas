function addBinary(a, b) {
  let str = (a + b)

  let cnc = ""
  for (; str > 1; str /= 2) {
    let num = str % 2
    cnc = Math.floor(num) + cnc
    console.log(cnc)
  }

  return cnc
}

console.log(addBinary(1, 2), "11");
console.log(addBinary(51, 12), "111111");
console.log(addBinary(10, 90), "1100100");



const cleverAddBinary = (a, b) => (a + b).toString(2)

console.log(cleverAddBinary(1, 2))
