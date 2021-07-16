const {
  expect
} = require("chai")

/**
 * Everybody has probably heard of the animal heads and legs problem from the earlier years at school.It goes:
 * “A farm contains chickens and cows.There are x heads and y legs.How many chickens and cows are there ? ”
 * Where x <= 1000 and y <= 1000
 */
describe("Example test cases", function () {

  it("Valid number of animals", function () {
    expect(animals(72, 200)).to.deep.equal([44, 28])
    expect(animals(116, 282)).to.deep.equal([91, 25])
    expect(animals(12, 24)).to.deep.equal([12, 0])
    expect(animals(6, 24)).to.deep.equal([0, 6])
    expect(animals(344, 872)).to.deep.equal([252, 92])
    expect(animals(158, 616)).to.deep.equal([8, 150])
  })

  it("Invalid number of animals", function () {
    expect(animals(25, 555)).to.deep.equal("No solutions")
    expect(animals(12, 25)).to.deep.equal("No solutions")
    expect(animals(54, 956)).to.deep.equal("No solutions")
    expect(animals(5455, 54956)).to.deep.equal("No solutions")
  })

  it("Edge cases", function () {
    expect(animals(0, 0)).to.deep.equal([0, 0])
    expect(animals(-1, -1)).to.deep.equal("No solutions")
    expect(animals(-45, 5)).to.deep.equal("No solutions")
    expect(animals(500, 0)).to.deep.equal("No solutions")
    expect(animals(0, 500)).to.deep.equal("No solutions")
    expect(animals(5, -55)).to.deep.equal("No solutions")
  })
})

//return [Chickens, Cows]
function animals(heads, legs) {
  if (heads === 0 && legs === 0) return [0, 0]
  if (heads <= 0 || legs <= 0) return "No solutions"
  if (heads * 4 < legs) return "No solutions"

  console.log(`heads: ${heads} and legs: ${legs}`)

  const cows = legs / 2 - heads
  const chickens = heads - cows

  if (cows % 1 !== 0) return "No solutions"


  return [chickens, cows]
}

function animalsV2(heads, legs) {
  if (heads === 0 && legs === 0) return [0, 0]

  const cows = legs / 2 - heads
  const chickens = heads - cows

  if (cows % 1 !== 0 || cows < 0 || chickens < 0) return "No solutions"

  return [chickens, cows]
}