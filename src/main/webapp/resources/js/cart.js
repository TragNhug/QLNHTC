/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
function addToCart(id, name, price) {
    event.preventDefault();
    fetch("/QLNHTC/api/cart", {
        method: "post",
        body: JSON.stringify({
            "productId": id,
            "productName": name,
            "price": price,
            "quantity": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data;

    });
}

function updateCart(obj, productName) {
    fetch("/QLNHTC/api/cart", {
        method: "put",
        body: JSON.stringify({
            "productId": "",
            "productName": productName,
            "price": 0,
            "quantity": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data.counter;
        
        let amount = document.getElementById("amountCart")
        amount.innerText = data.amount;

    });
}

function deleteCart(productName) {

    fetch(`/QLNHTC/api/cart/'${productName}'`, {
        method: "delete"
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data.counter;
        
        let amount = document.getElementById("amountCart")
        amount.innerText = data.amount;
        location.reload();
    })
}

function pay(){
    if(confirm("Ban chac chan thanh toán?") == true){
        fetch("/QLNHTC/api/cart/pay", {
            method: "post"
        }).then(function(res){
            return res.json();
        }).then(function (code){
            console.info(code);
            location.reload();
        })
    }
}