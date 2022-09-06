/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


function deleteEmployee(id)
{
    fetch(`/QLNHTC/admin/employee/${id}`, {
        method: "delete"
    }).then(function () {
        location.reload();
    })
}