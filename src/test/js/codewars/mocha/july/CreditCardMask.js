const {
  assert
} = require("chai")

/**
 * Usually when you buy something, you 're asked whether your credit card number,
 * phone number or answer to your most secret question is still correct. 
 * However, since someone could look over your shoulder, you don't
 * want that shown on your screen.Instead, we mask it.
 * 
 * Your task is to write a function maskify, 
 * which changes all but the last four characters into '#'.
 * 
 * maskify("4556364607935616") == "############5616"
 * maskify("64607935616") == "#######5616"
 * maskify("1") == "1"
 * maskify("") == ""
 * 
 * // "What was the name of your first pet?"
 *  maskify("Skippy") == "##ippy"
 * maskify("Nananananananananananananananana Batman!") == "####################################man!"
 */
describe("Credit Card Mask", () => {

  it("should work for some examples", () => {
    assert.equal(maskify('4556364607935616'), '############5616');
    assert.equal(maskify('1'), '1');
    assert.equal(maskify('11111'), '#1111');
  })

  it("test best codewars with examples", () => {
    assert.equal(maskify('4556364607935616'), '############5616');
    assert.equal(maskify('1'), '1');
    assert.equal(maskify('11111'), '#1111');
  })
})

function maskify(input) {
  const trimmed = input.trim()

  if (trimmed.length < 5) return trimmed

  const lastFour = trimmed.length - 4
  const sliced = trimmed.slice(lastFour, input.length)

  return '#'.repeat(lastFour) + sliced
}

function bestOfCodewars(input) {
  return input.slice(0, -4).replace(/./g, '#') + input.slice(-4)
}