const { assert } = require("chai")

describe("String.prototype.toAlternatingCase", () => {
  it("should work for fixed asserts (provided in the description)", () => {
    assert.assertEquals("hello world".toAlternatingCase(), "HELLO WORLD");
    assert.assertEquals("HELLO WORLD".toAlternatingCase(), "hello world");
    assert.assertEquals("hello WORLD".toAlternatingCase(), "HELLO world");
    assert.assertEquals("HeLLo WoRLD".toAlternatingCase(), "hEllO wOrld");
    assert.assertEquals("12345".toAlternatingCase(), "12345");
    assert.assertEquals("1a2b3c4d5e".toAlternatingCase(), "1A2B3C4D5E");
    assert.assertEquals("String.prototype.toAlternatingCase".toAlternatingCase(), "sTRING.PROTOTYPE.TOaLTERNATINGcASE");
    assert.assertEquals("Hello World".toAlternatingCase().toAlternatingCase(), "Hello World");
  });
});


String.prototype.toAlternatingCase = function () {
  this.map
}