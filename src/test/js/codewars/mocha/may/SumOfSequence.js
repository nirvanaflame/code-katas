const range = (start, stop, step) => Array.from({ length: (stop - start) / step + 1 }, (_, i) => start + (i * step))

const sequenceSum = (begin, end, step) => begin > end ? 0 : range(begin, end, step).reduce((acc, each) => acc + each)

console.log(sequenceSum(2, 6, 2), 12)
console.log(sequenceSum(1, 5, 1), 15)
console.log(sequenceSum(1, 5, 3), 5)
console.log(sequenceSum(1, 0, 3), 0)



const sequenceSumRecursion = (b, e, s) => b > e ? 0 : b + sequenceSum(b + s, e, s);


console.log(sequenceSumRecursion(1, 50, 1.5), 825)
