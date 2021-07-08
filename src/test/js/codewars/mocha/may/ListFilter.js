function filter_list(l) {
    return l.filter(it => Number.isInteger(it));
}

console.log(filter_list([1, 2, 'a', 'b']), [1, 2])
console.log(filter_list([1, 'a', 'b', 0, 15]), [1, 0, 15])
console.log(filter_list([1, 2, 'aasf', '1', '123', 123]), [1, 2, 123])


function filter_list_method_reference(l) {
    return l.filter(Number.isInteger);
}

console.log(filter_list_method_reference([1, 2, 'a', 'b']), [1, 2])


function filter_list_typeof(l) {
    return l.filter(it => typeof it == "number");
}

console.log(filter_list_typeof([1, 2, 'a', 'b']), [1, 2])


