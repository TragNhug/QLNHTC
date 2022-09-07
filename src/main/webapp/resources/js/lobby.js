/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function deleteLobby(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let load = document.getElementById(`load${id}`);
    load.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Something wrong!!!");
        load.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        btn.style.display = "block";
        load.style.display = "none";
    });
}

function viewUpdate(id){
    fetch(`/QLNHTC/api/updateLobby/${id}`, {
        method: "post"
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        document.getElementById("name").value=data.name;
        document.getElementById("price").value=data.price;
        document.getElementById("qtytable").value=data.qtytable;
        document.getElementById("qtystaff").value=data.qtystaff;
        
        
    })
}


function loadLobies(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        let d = document.getElementById("myLobby");
        let msg = "";
        for (let i = 0; i < data.length; i++)
            msg += `<tr>
                    <td><img src="${data[i].image}" width="120"/></td>
        
                    <td>${data[i].name}</td>
                    <td>${data[i].price} VND</td>
                    <td>
                       
                        <a type="button" href="/QLNHTC/admin/updateLobby/${data[i].id}" class="btn btn-danger" >Cap nhat</a>
                    </td>
                    <td>
                        <div class="spinner-border text-info" style="display:none" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteLobby('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">xóa</button>
                    </td>
                    
                </tr>`

        d.innerHTML = msg;
        let d2 = document.getElementById("myLoading");
        d2.style.display = "none"
    })
}

