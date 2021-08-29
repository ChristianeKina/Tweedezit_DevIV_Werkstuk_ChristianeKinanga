function demo(){
    let person = makePerson("Chris", "Malr");
    let product = makeProduct("Paper", 6);
    let product1 = makeProduct("Bag", 5);
    let shoppingCart = makeShoppingCart(person, [product]);
    let shoppingCart1 = addItemToShoppingCart(shoppingCart, product1);
    console.log(shoppingCart1);
    let shop = addShoppingCartToShop(shoppingCart1, []);
    console.log(shop);
    assembleShoppingCart(shop, payWithCard);
    
}

function makeProduct(name, price){
    let product = {name: name, price: price};
    return product;
}

function makePerson(firstName, lastName){
    let person = {firstName: firstName, lastName: lastName};
    return person;
}

function notifyObserver(shoppingCart){
    console.log(`${shoppingCart.person.firstName}${shoppingCart.person.lastName}'s shopping cart is assembled`);
}

function makeShoppingCart(person, items){
    let shoppingCart = {person: person, items: items};
    return shoppingCart;
}

function addItemToShoppingCart(shoppingCart, item){
    let list = shoppingCart.items.concat([item]);
    return makeShoppingCart(shoppingCart.person, list);
}

function addShoppingCartToShop(shoppingCart, shop){
    return shop.concat([shoppingCart]);
}

function assembleShoppingCart(shop, payMethod){
    if (shop.length > 0) {
        let newShop = JSON.parse(JSON.stringify(shop));
        let shoppingCart = newShop[0];
        notifyObserver(shoppingCart);
        payMethod(shoppingCart);
        return newShop.slice(1);
    }
}

function amount(shoppingCart){
    return shoppingCart.items.reduce((total, item) => total.price + item.price);
}


function payWithCash(shoppingCart){
  console.log(`The shopping cart was paid with cash and the amount is ${amount(shoppingCart)}`);

}

function payWithCard(shoppingCart){
     console.log(`The shopping cart was paid by card ${amount(shoppingCart)}`);
}

demo();
