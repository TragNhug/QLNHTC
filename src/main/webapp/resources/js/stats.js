/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function generateColor(){
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r}, ${g}, ${b})`;
}

function weddingChart(id, productLabels=[], productInfo=[]){
    let colors = [];
    for(let i = 0; i < productInfo.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: productLabels,
        datasets: [{
                labels: 'Thống kê mật độ tiệc cưới',
                data: productInfo,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
        }]
    };
    const config = {
        type: 'bar', 
        data: data
    };
    
    let ctx = document.getElementById(id).getContext("2d")
    
    new Chart(ctx, config)
        
}
function weddingChartYear(id, productLabelsYear=[], productInfoYear=[]){
    let colors = [];
    for(let i = 0; i < productInfoYear.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: productLabelsYear,
        datasets: [{
                labels: 'Thống kê mật độ tiệc cưới',
                data: productInfoYear,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
        }]
    };
    const config = {
        type: 'bar', 
        data: data
    };
    
    let ctx = document.getElementById(id).getContext("2d")
    
    new Chart(ctx, config)
        
}
function weddingChartYear(id, productLabelsQuarter=[], productInfoQuarter=[]){
    let colors = [];
    for(let i = 0; i < productInfoQuarter.length; i++)
        colors.push(generateColor());
    
    const data = {
        labels: productLabelsQuarter,
        datasets: [{
                labels: 'Thống kê mật độ tiệc cưới',
                data: productInfoQuarter,
                backgroundColor: colors,
                borderColor: colors,
                hoverOffset: 4
        }]
    };
    const config = {
        type: 'bar', 
        data: data
    };
    
    let ctx = document.getElementById(id).getContext("2d")
    
    new Chart(ctx, config)
        
}