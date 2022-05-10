describe("Friend and foe", () => {

  it('My solution', () => {
    // console.log(friend(["Ryan", "Kieran", "Mark"]), ["Ryan", "Mark"]);
    // console.log(friend(["Ryan", "Jimmy", "123", "4", "Cool Man"]), ["Ryan"]);
    // console.log(friend(["Jimm", "Cari", "aret", "truehdnviegkwgvke", "sixtyiscooooool"]), ["Jimm", "Cari", "aret"]);
    // console.log(friend(["Love", "Your", "Face", "1"]), ["Love", "Your", "Face"]);
  })
})

function friend(names) {
  return names.filter(it => it.length === 4 && isNaN(it))
}