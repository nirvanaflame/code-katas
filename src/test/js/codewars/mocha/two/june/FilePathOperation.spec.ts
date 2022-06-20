import { assert } from 'chai';


class FileMaster {
  constructor(public filepath: string) { }

  extension() {
    return this.filepath.split('.')[1];
  }

  filename() {
    const names = this.filepath.split('.')[0].split('/')
    return names[names.length - 1]
  }

  dirpath() {
    return this.filepath.split('/').slice(0, -1).join('/') + '/'
  }
}


describe('FileMaster', function () {
  const fm = new FileMaster('/Users/person1/Pictures/house.png');

  it('extension', function () {
    assert.equal(fm.extension(), 'png');
  });

  it('filename', function () {
    assert.equal(fm.filename(), 'house');
  });

  it('dirpath', function () {
    assert.equal(fm.dirpath(), '/Users/person1/Pictures/');
  });
});



// const file = new FileMaster('/Users/person1/Pictures/house.png')

// console.log(file.extension())
// console.log(file.filename())
// console.log(file.dirpath())
