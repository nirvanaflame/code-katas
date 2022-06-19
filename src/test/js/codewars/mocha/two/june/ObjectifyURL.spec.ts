import { assert } from "chai";


describe("Objectify URL", () => {
  it("basic test", () => {
    var q = 'user.name.firstname=Bob&user.name.lastname=Smith&user.favoritecolor=Light%20Blue',
      out = {
        'user': {
          'name': {
            'firstname': 'Bob',
            'lastname': 'Smith'
          },
          'favoritecolor': 'Light Blue'
        }
      };
    assert.deepEqual(convertQueryToMap(q), out);
  });
});


function convertQueryToMap(query: string): object {
  const params = query.split('&');
  
  const obj = {};
  params.forEach(param => {
    const [key, val] =param.split('=');
    const path = key.split('.');

    createNestedObject(obj, path, val);
  })
  // console.log(obj)

  return obj;
}


const createNestedObject = function( obj: object, keyPath: string[], value: string ): void {
  value = (value) ? decodeURIComponent(value) : '';
  const lastKeyIndex = keyPath.length - 1;
  
  for (let i = 0; i < keyPath.length; i++) {
    const key = keyPath[i];

    if (!(key in obj)) {
      if (i === lastKeyIndex)
        obj[key] = value;
      else 
        obj[key] = {};
    }
    obj = obj[key];
  }
}

// console.log(convertQueryToMap('user.name.firstname=Bob&user.name.lastname=Smith&user.favoritecolor=Light%20Blue'))