describe('Printer of errors', () => {
  var str = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"

  it('My solution', () => {
    // console.log(printerError(str), "3/56")
  })

  it('Best from codewars', () => {
    // console.log(printerErrorWithPlaceHolder(str), "3/56")
  })
})


function printerError(s) {
  const invalid = s.replaceAll(/[a-m]/gi, '')
  return invalid.length + "/" + s.length
}

const printerErrorWithPlaceHolder = it => `${it.replace(/[a-m]/gi, "").length}/${it.length}`;