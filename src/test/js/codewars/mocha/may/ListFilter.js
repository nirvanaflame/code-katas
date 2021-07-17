describe("List filter", () => {

    it('My solution for filtering list', () => {
        // console.log(filterList([1, 2, 'a', 'b']), [1, 2])
        // console.log(filterList([1, 'a', 'b', 0, 15]), [1, 0, 15])
        // console.log(filterList([1, 2, 'aasf', '1', '123', 123]), [1, 2, 123])
    })

    it('JS method reference code example', () => {
        // console.log(filterListWithMethodReference([1, 2, 'a', 'b']), [1, 2])
    })

    it('JS type of example', () => {
        // console.log(filterListWithTypeOf([1, 2, 'a', 'b']), [1, 2])
    })
})

function filterList(l) {
    return l.filter(it => Number.isInteger(it));
}

function filterListWithMethodReference(l) {
    return l.filter(Number.isInteger);
}

function filterListWithTypeOf(l) {
    return l.filter(it => typeof it == "number");
}