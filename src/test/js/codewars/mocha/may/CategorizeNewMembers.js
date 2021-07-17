describe("Categorize new members", () => {

  it('My solution', () => {
    // console.log(openOrSenior([
    //   [45, 12],
    //   [55, 21],
    //   [19, -2],
    //   [104, 20]
    // ]), ['Open', 'Senior', 'Open', 'Senior'])
    // console.log(openOrSenior([
    //   [3, 12],
    //   [55, 1],
    //   [91, -2],
    //   [54, 23]
    // ]), ['Open', 'Open', 'Open', 'Open'])
    // console.log(openOrSenior([
    //   [59, 12],
    //   [55, -1],
    //   [12, -2],
    //   [12, 12]
    // ]), ['Senior', 'Open', 'Open', 'Open'])
  })
  it('Best from codewars', () => {
    // console.log(openOrSeniorWithDesctruction([
    //   [45, 12],
    //   [55, 21],
    //   [19, -2],
    //   [104, 20]
    // ]), ['Open', 'Senior', 'Open', 'Senior'])
    // console.log(openOrSeniorWithDesctruction([
    //   [3, 12],
    //   [55, 1],
    //   [91, -2],
    //   [54, 23]
    // ]), ['Open', 'Open', 'Open', 'Open'])
    // console.log(openOrSeniorWithDesctruction([
    //   [59, 12],
    //   [55, -1],
    //   [12, -2],
    //   [12, 12]
    // ]), ['Senior', 'Open', 'Open', 'Open'])
  })
})

function openOrSenior(data) {
  return data.map(person => {
    const age = person[0]
    const rank = person[1]

    return age >= 55 && rank > 7 ? 'Senior' : 'Open'
  })
}

function openOrSeniorWithDesctruction(data) {
  return data.map(([age, rank]) => age >= 55 && rank > 7 ? 'Senior' : 'Open')
}