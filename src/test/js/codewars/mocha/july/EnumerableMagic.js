const should = require("chai").should()


/**
 * Create a method all which takes an array and a predicate (function pointer), 
 * and returns true if the predicate returns true for every element in the array. 
 * Otherwise, it should return false. If the array is empty, 
 * it should return true, since technically nothing failed the test.
 */
describe('True for all', () => {

  describe('My solution', () => {
    it('should return true for empty array', () => {
      all([], (it) => it % 2 == 0).should.to.be.true
    })

    it('should return true after filter because size has not changed ', () => {
      all([1, 2, 3, 4], (it) => it > 0).should.to.be.true
    })

    it('should return false after filter because size has changed ', () => {
      all([1, 2, 3, 4], (it) => it > 0).should.to.be.true
    })
  })

  describe('Codewars best solution', () => {
    it('should return true for empty array', () => {
      codeWarsAll([], (it) => it % 2 === 0).should.to.be.true
    })

    it('should return true after filter because size has not changed ', () => {
      codeWarsAll([1, 2, 3, 4], (it) => it > 0).should.to.be.true
    })

    it('should return false after filter because size has changed ', () => {
      codeWarsAll([1, 2, 3, 4], (it) => it > 0).should.to.be.true
    })
  })





})


function all(arr, fun) {
  return arr.length - arr.filter(it => fun(it)).length === 0
}

const codeWarsAll = (arr, fun) => arr.every(fun)