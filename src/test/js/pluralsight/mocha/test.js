const { expect, assert } = require("chai")
const should = require("chai").should()


describe("Welcome to Mocha!", () => {

  before(() => {
    console.log("################################")
  })

  beforeEach(() => {
    console.log("Before each")
  })

  afterEach(() => {
    console.log("After each")
  })

  after(() => {
    console.log("################################")
  })

  describe.only("There three different ways for assertion", () => {

    it("1) expect syntax", () => {
      expect(1 + 1).to.be.equal(2)
      expect(18 / 2).to.eq(9)
    })

    it("2) should syntax", () => {
      const result = 1 + 3
      result.should.equal(4)
    })

    it.skip("3) assert syntax", () => {
      assert.equal(2 + 5, 7)
    })
  })

  it("4) Not gonna be executed because of .only", () => {
    assert.equal(2 + 5, 7)
  })
})