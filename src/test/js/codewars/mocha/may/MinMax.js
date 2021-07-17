describe('Min and max', () => {

  it('My solution', () => {
    // console.log(minMax([1, 2, 3, 4, 5]), [1, 5]);
    // console.log(minMax([2334454, 5]), [5, 2334454]);
  })

  it('Best from codewars', () => {
    // console.log(minMaxClever([-5, -2, 0, 1, 2, 3, 4, 5]), [-5, 5]);
    // console.log(oneLinerMinMax([-5, -2, 0, 1, 2, 3, 4, 5]), [-5, 5]);
  })
})

function minMax(arr) {
  return [
    arr.reduce((acc, each) => acc > each ? acc = each : acc),
    arr.reduce((acc, each) => acc < each ? acc = each : acc)
  ]
}

function minMaxClever(arr) {
  return [Math.min(...arr), Math.max(...arr)]
}

const oneLinerMinMax = (arr) => [Math.min(...arr), Math.max(...arr)]