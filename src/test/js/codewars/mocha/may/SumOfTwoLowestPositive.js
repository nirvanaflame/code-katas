describe('Sum of two lowest positive numbers', () => {

    it('My solution', () => {
        // console.log(sum([5, 8, 12, 19, 22]), 13, "Sum should be 13");
        // console.log(sum([15, 28, 4, 2, 43]), 6, "Sum should be 6");
        // console.log(sum([3, 87, 45, 12, 7]), 10, "Sum should be 10");
        // console.log(sum([23, 71, 33, 82, 1]), 24, "Sum should be 24");
        // console.log(sum([52, 76, 14, 12, 4]), 16, "Sum should be 16");
    })

    it('Best from codewars', () => {
        // console.log(sumOfTwo([52, 76, 14, 12, 4]), 16, "Sum should be 16");
    })
})

function sum(numbers) {
    return numbers.sort((a, b) => a - b)
        .slice(0, 2)
        .reduce((acc, e) => acc + e)
}

function sumOfTwo(numbers) {
    var [x, y] = numbers.sort((a, b) => a - b)
    return x + y
}