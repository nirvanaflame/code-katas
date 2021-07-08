function printerError(s) {
  const invalid = s.replaceAll(/[a-m]/gi, '')
  return invalid.length + "/" + s.length
}

var str = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"
console.log(printerError(str), "3/56")



const printerErrorWithPlaceHolder = it => `${it.replace(/[a-m]/gi, "").length}/${it.length}`;

console.log(printerErrorWithPlaceHolder(str), "3/56")