

export function twoSort(s: string[]): string {
  return s.sort()[0].split("").join("***");
}

// console.log(twoSort(["bitcoin", "take", "over", "the", "world", "maybe", "who", "knows", "perhaps"]))


// ----- NEXT ONE


export const toQueryString = (obj: object): string => 
    Object.entries(obj).reduce((prev, [key, value]) => prev + associate(key, value) + '&', '').slice(0, -1);

const associate = (key: string, value: any) =>  Array.isArray(value) ? 
    value.flatMap((x) => `${key}=${x}`).join('&') :
    `${key}=${value}`


// console.log(toQueryString({ a: 'Z', b: 'Y', c: 'X', d: 'W', e: 'V', f: 'U', g: 'T' }))
// console.log(toQueryString({ foo: [1, 3], bar: [2, 4] }))
